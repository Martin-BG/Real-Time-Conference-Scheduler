package com.codexio.rtcs;

import com.codexio.rtcs.services.ConferenceService;
import com.codexio.rtcs.services.HallService;
import com.codexio.rtcs.services.SessionService;
import com.codexio.rtcs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class Terminal implements CommandLineRunner {

    private final ConferenceService conferenceService;
    private final HallService hallService;
    private final SessionService sessionService;
    private final UserService userService;

    @Autowired
    public Terminal(
            final ConferenceService conferenceService,
            final HallService hallService,
            final SessionService sessionService,
            final UserService userService) {
        this.conferenceService = conferenceService;
        this.hallService = hallService;
        this.sessionService = sessionService;
        this.userService = userService;
    }

    @Override
    public void run(final String... args) {
/*        UserRegisterBindingDto user = new UserRegisterBindingDto();
        user.setName("Pesho");
        user.setEmail("pesho@abv.bg");
        user.setPassword("password");
        user.setConfirmPassword("password");
        this.userService.create(user);*/
    }
}
