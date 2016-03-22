package com.zdc.zl.service;

import com.zdc.zl.model.Guest;
import com.zdc.zl.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dachuan on 3/21/16.
 */
@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;
    public int reserveGuest(Guest guest)
    {
        return 1;
    }

    public boolean updateGuest(Guest guest)
    {
        return true;
    }

    public boolean deleteGuest(Guest guest)
    {
        return true;
    }
}
