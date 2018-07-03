package com.codexio.rtcs;

import com.codexio.rtcs.entities.User;
import com.codexio.rtcs.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.HashSet;

@Controller
public class Terminal implements CommandLineRunner {

    private final ConferenceService conferenceService;
    private final AddressService addressService;
    private final HallService hallService;
    private final SessionService sessionService;
    private final UserService userService;

    @Autowired
    public Terminal(
            final ConferenceService conferenceService,
            final AddressService addressService,
            final HallService hallService,
            final SessionService sessionService,
            final UserService userService) {
        this.conferenceService = conferenceService;
        this.addressService = addressService;
        this.hallService = hallService;
        this.sessionService = sessionService;
        this.userService = userService;
    }

    @Override
    public void run(final String... args) {
        User user = new User();
        user.setName("Pesho");
        user.setEmail("pesho@abv.bg");
        user.setPassword("password");
        this.userService.create(user);
    }

}
