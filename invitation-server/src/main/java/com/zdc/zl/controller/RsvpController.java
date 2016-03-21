package com.zdc.zl.controller;

import com.zdc.zl.model.Guest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dachuan on 3/20/16.
 */
@RestController
public class RsvpController {
    @RequestMapping(value = "/guest",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String makeReservation(@RequestBody Guest guest) {
        System.out.println("guest = " + guest);
        return null;
    }

    @RequestMapping(value = "/guest", method = RequestMethod.GET)
    public String makeReservation() {
        System.out.println("hello");
        return null;
    }
}
