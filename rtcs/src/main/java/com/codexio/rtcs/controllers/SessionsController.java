package com.codexio.rtcs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sessions")
public class SessionsController extends BaseController {

    @GetMapping("/all")
    public ModelAndView getAll() {
        return super.view("/sessions/all");
    }
}
