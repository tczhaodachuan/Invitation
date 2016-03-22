package com.zdc.zl.controller;

import com.zdc.zl.model.Guest;
import com.zdc.zl.model.Response;
import com.zdc.zl.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dachuan on 3/20/16.
 */
@RestController
public class RsvpController {
    @Autowired
    private GuestService guestService;

    @RequestMapping(value = "/guest",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Response> makeReservation(@RequestBody Guest guest) {
        System.out.println("guest = " + guest);
        Response response = new Response(guest.getId());
        try {
            if (guestService.reserveGuest(guest)) {
                System.out.println("id is created " + guest.getId());
            }
        } catch (Exception e) {
            System.out.println("e = " + e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/guest",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Response> cancelReservation(@RequestBody Guest guest) {
        System.out.println("guest = " + guest);
        Response response = new Response(guest.getId());
        try {
            if (!guestService.deleteGuest(guest)) {
                System.out.println(guest + " failed to be removed");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            System.out.println("e = " + e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/guest/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Guest makeReservation(@PathVariable int id) {
        return guestService.findGuest(id);
    }

    @RequestMapping(value = "/guest", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Guest> makeReservation() {
        return guestService.findAllGuests();
    }
}
