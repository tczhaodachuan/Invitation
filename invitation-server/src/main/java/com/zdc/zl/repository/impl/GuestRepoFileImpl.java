package com.zdc.zl.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zdc.zl.model.Guest;
import com.zdc.zl.repository.GuestRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dachuan on 3/21/16.
 */
@Service
public class GuestRepoFileImpl implements GuestRepository {
    private Log logger = LogFactoryImpl.getLog(GuestRepoFileImpl.class);
    private ConcurrentHashMap<Integer, Guest> cache;
    @Value("${reservation.directory}")
    private String directory;

    @PostConstruct
    public void init() throws IOException {
        logger.info(directory);
        Files.walk(Paths.get(directory)).forEach(filePath -> {
            if (Files.isRegularFile(filePath)) {
                logger.info(filePath);
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath.toFile()))) {
                    String json = bufferedReader.readLine();
                    Guest guest = new ObjectMapper().readValue(json, Guest.class);
                    cache.put(guest.getId(), guest);
                } catch (IOException e) {
                    logger.error(e, e);
                }
            }

        });
    }

    public synchronized String getUpdateFileName() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return String.format("(%s)/update.(%4d).(%2d).(%s)", directory, localDateTime.getYear(), localDateTime.getDayOfMonth(), localDateTime.getMonth());
    }

    public synchronized String getReserveFileName() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return String.format("(%s)/reverve.(%4d).(%2d).(%s)", directory, localDateTime.getYear(), localDateTime.getDayOfMonth(), localDateTime.getMonth());
    }

    public synchronized String getCancelDataFileName() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return String.format("(%s)/cancel.(%4d).(%2d).(%s)", directory, localDateTime.getYear(), localDateTime.getDayOfMonth(), localDateTime.getMonth());
    }

    public boolean reserveGuest(Guest guest) {
        if (cache.containsKey(guest.getId())) {
            return false;
        }
        cache.put(guest.getId(), guest);

        String fileName = getReserveFileName();
        return saveToFile(guest, fileName);
    }

    public boolean updateGuest(Guest guest) {
        if (cache.containsKey(guest.getId())) {
            cache.put(guest.getId(), guest);
        } else {
            return false;
        }

        String fileName = getUpdateFileName();
        return saveToFile(guest, fileName);
    }

    public boolean deleteGuest(Guest guest) {
        cache.remove(guest.getId());
        String fileName = getCancelDataFileName();
        return saveToFile(guest, fileName);
    }

    public Guest findGuest(Guest guest) {
        return findGuest(guest.getId());
    }

    public Guest findGuest(int id) {
        return cache.get(id);
    }

    @Override
    public List<Guest> findAllGuests() {
        return new ArrayList<>(cache.values());
    }

    private boolean saveToFile(Guest guest, String fileName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName), true)) {
            new ObjectMapper().writeValue(fileOutputStream, guest);
            return true;
        } catch (IOException e) {
            logger.error(e, e);
            return false;
        }
    }

}
