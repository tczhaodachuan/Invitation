package com.zdc.zl.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zdc.zl.model.Guest;
import com.zdc.zl.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dachuan on 3/21/16.
 */
@Service
public class GuestRepoFileImpl implements GuestRepository {
    private ConcurrentHashMap<Integer, Guest> cache;
    @Value("${reservation.directory}")
    private String directory;

    @PostConstruct
    public void init() throws IOException {
        System.out.println("directory = " + directory);
        Files.walk(Paths.get(directory)).forEach(filePath -> {
            if (Files.isRegularFile(filePath)) {
                System.out.println(filePath);
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath.toFile()))) {
                    String json = bufferedReader.readLine();
                    Guest guest = new ObjectMapper().readValue(json, Guest.class);
                    cache.put(guest.getId(), guest);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public int reserveGuest(Guest guest) {
        return 0;
    }

    public boolean updateGuest(Guest guest) {
        return false;
    }

    public boolean deleteGuest(Guest guest) {
        return false;
    }

    public Guest findGuest(Guest guest) {
        return null;
    }

    public Guest findGuest(int id) {
        return null;
    }
}
