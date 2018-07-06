package com.codexio.rtcs.controllers;

import com.codexio.rtcs.models.binding.ConferenceCreateBindingDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/conferences")
public class ConferencesController extends BaseController {

    @GetMapping("/all")
    public ModelAndView getAll() {
        return super.view("/conferences/all");
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return super.view("/conferences/create");
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute("dto") ConferenceCreateBindingDto conferenceCreateBindingDto,
                               BindingResult result,
                               HttpSession session) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
/*        auth.
        UserViewDto userExists = userService.getByEmail(userRegisterBindingDto.getEmail());

        if (userExists != null) {
            result.rejectValue("email", "error.user",
                    "There is already a user registered with the email provided");
        }

        if (!userRegisterBindingDto.getPassword().equals(userRegisterBindingDto.getConfirmPassword())) {
            result.rejectValue("password", "error.password",
                    "Password and Confirm Password do not match");
        }

        final UserViewDto userViewDto = userService.create(userRegisterBindingDto);

        if (userViewDto == null) {
            result.rejectValue("name", "error.register",
                    "Registration failed");
        }

        if (result.hasErrors()) {
            return super.view("/users/register");
//            result.getAllErrors().forEach(e -> System.out.println(e.getDefaultMessage()));
        }

        return super.redirect("/users/login");*/

        return super.view("/conferences/create");
    }
}
