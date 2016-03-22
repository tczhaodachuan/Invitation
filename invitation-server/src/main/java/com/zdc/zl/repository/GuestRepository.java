package com.zdc.zl.repository;

import com.zdc.zl.model.Guest;

import java.util.List;

/**
 * Created by dachuan on 3/21/16.
 */
public interface GuestRepository {
    boolean reserveGuest(Guest guest);

    boolean updateGuest(Guest guest);

    boolean deleteGuest(Guest guest);

    Guest findGuest(Guest guest);
    Guest findGuest(int id);
    List<Guest> findAllGuests();
}
