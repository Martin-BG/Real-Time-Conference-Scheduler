package com.codexio.rtcs;

import com.codexio.rtcs.entities.Role;
import com.codexio.rtcs.models.binding.RoleRegistrationBindingDto;
import com.codexio.rtcs.models.binding.UserRegisterBindingDto;
import com.codexio.rtcs.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class Terminal implements CommandLineRunner {

    private final ConferenceService conferenceService;
    private final AddressService addressService;
    private final HallService hallService;
    private final SessionService sessionService;
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public Terminal(
            final ConferenceService conferenceService,
            final AddressService addressService,
            final HallService hallService,
            final SessionService sessionService,
            final UserService userService,
    final RoleService roleService) {
        this.conferenceService = conferenceService;
        this.addressService = addressService;
        this.hallService = hallService;
        this.sessionService = sessionService;
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public void run(final String... args) {
        RoleRegistrationBindingDto adminRole = new RoleRegistrationBindingDto();
        adminRole.setRole("ADMIN");
        this.roleService.create(adminRole);

        RoleRegistrationBindingDto userRole = new RoleRegistrationBindingDto();
        userRole.setRole("USER");
        this.roleService.create(userRole);

        UserRegisterBindingDto user = new UserRegisterBindingDto();
        user.setName("Pesho");
        user.setEmail("pesho@abv.bg");
        user.setPassword("password");
        user.setConfirmPassword("password");
        this.userService.create(user);


    }

}
