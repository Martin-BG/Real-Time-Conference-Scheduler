package com.codexio.rtcs.controllers;

import com.codexio.rtcs.models.binding.UserRegisterBindingDto;
import com.codexio.rtcs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController extends BaseController {

    private final UserService userService;

    @Autowired
    public UsersController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                           Model model,
                           HttpSession session) {
//        model.addAttribute("name", ((UserRegisterDto)(session.getAttribute("user"))).getName());

        return "greeting";
    }

    @GetMapping("/register")
    public String userRegisterGet() {
        return "user-register";
    }

    @PostMapping("/register")
    public ModelAndView userRegisterPost(@Valid @ModelAttribute("dto") UserRegisterBindingDto userRegisterBindingDto,
                                         BindingResult result,
                                         ModelAndView modelAndView,
                                         RedirectAttributes redirectAttributes,
                                         HttpSession session) {


        session.setAttribute("user", userRegisterBindingDto);
        if (result.hasErrors()) {
            result.getAllErrors().forEach(e -> System.out.println(e.getDefaultMessage()));
        }

        userService.create(userRegisterBindingDto);
//        redirectAttributes.addFlashAttribute("name", dto.getName());
//        modelAndView.addObject("name", dto.getName());
        modelAndView.setViewName("redirect:/greeting");
        return modelAndView;
//        return "redirect:/greeting?name=" + dto.getName();
    }
}
