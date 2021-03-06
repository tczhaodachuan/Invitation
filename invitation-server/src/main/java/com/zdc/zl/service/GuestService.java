package com.zdc.zl.service;

import com.zdc.zl.model.Guest;
import com.zdc.zl.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dachuan on 3/21/16.
 */
@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public Guest findGuest(int id) {
        return guestRepository.findGuest(id);
    }

    public List<Guest> findAllGuests() {
        return guestRepository.findAllGuests();
    }

    public Guest findGuest(Guest guest) {
        return guestRepository.findGuest(guest);
    }

    public boolean reserveGuest(Guest guest) {
        return guestRepository.reserveGuest(guest);
    }

    public boolean updateGuest(Guest guest) {
        return guestRepository.updateGuest(guest);
    }

    public boolean deleteGuest(Guest guest) {

        return guestRepository.deleteGuest(guest);
    }
}
