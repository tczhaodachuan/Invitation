package com.zdc.zl.repository;

import com.zdc.zl.model.Guest;

/**
 * Created by dachuan on 3/21/16.
 */
public interface GuestRepository {
    int reserveGuest(Guest guest);

    boolean updateGuest(Guest guest);

    boolean deleteGuest(Guest guest);
}
