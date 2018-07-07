package com.codexio.rtcs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/halls")
public class HallsController extends BaseController {

    @GetMapping("/create")
    public ModelAndView createGet() {
        return super.view("/halls/create");
    }

    @PostMapping("/create")
    public ModelAndView createPost() {
        return super.view("/halls/create");
        //TODO
    }

}
