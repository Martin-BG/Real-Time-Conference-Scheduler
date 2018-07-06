package com.codexio.rtcs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {

    @GetMapping(value = {"/home"})
    public ModelAndView home() {
        return super.view("/home");
    }

    @GetMapping(value = {"", "/"})
    public ModelAndView index() {
        return super.redirect("/home");
    }
}
