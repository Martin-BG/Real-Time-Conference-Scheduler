package com.codexio.rtcs.controllers;

import com.codexio.rtcs.models.binding.UserRegisterBindingDto;
import com.codexio.rtcs.models.view.UserViewDto;
import com.codexio.rtcs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController extends BaseController {

    private final UserService userService;

    @Autowired
    public UsersController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView userLoginGet() {
        return super.view("/users/login");
    }

/*    @PostMapping("/login")
    public ModelAndView userLoginPost(@Valid @ModelAttribute("dto") UserLoginBindingDto userLoginBindingDto,
                                      BindingResult result) {
        if (result.hasErrors()) {
            result.getAllErrors().forEach(e -> System.out.println(e.getDefaultMessage()));
        }

        if (!userService.isPasswordValid(userLoginBindingDto)) {
            return super.redirect("/users/login");
        }

        return super.redirect("/home");
    }*/

    @GetMapping("/register")
    public ModelAndView userRegisterGet() {
        return super.view("/users/register");
    }

    @PostMapping("/register")
    public ModelAndView userRegisterPost(@Valid @ModelAttribute("dto") UserRegisterBindingDto userRegisterBindingDto,
                                         BindingResult result) {

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

        return super.redirect("/users/login");
    }
}
