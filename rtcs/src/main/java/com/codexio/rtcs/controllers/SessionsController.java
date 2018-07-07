package com.codexio.rtcs.controllers;

import com.codexio.rtcs.services.ConferenceService;
import com.codexio.rtcs.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sessions")
public class SessionsController extends BaseController {

    private final SessionService sessionService;
    private final ConferenceService conferenceService;

    @Autowired
    public SessionsController(final SessionService sessionService,
                              final ConferenceService conferenceService) {
        this.sessionService = sessionService;
        this.conferenceService = conferenceService;
    }


    @GetMapping("/all")
    public ModelAndView allGet() {
        return super.view("/sessions/all");
    }

    @GetMapping("/all/{id}")
    public ModelAndView details(@PathVariable String id) {
        ModelAndView modelAndView = super.view("/sessions/all");
        modelAndView.addObject("sessions", this.conferenceService.getSessions(id));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createGet() {
        return super.view("/sessions/create");
    }

    @PostMapping("/create")
    public ModelAndView createPost() {
        return super.view("/sessions/create");
        //TODO
    }

    @GetMapping("/edit")
    public ModelAndView editGet() {
        return super.view("/sessions/edit");
    }

    @PostMapping("/edit")
    public ModelAndView editPost() {
        return super.view("/sessions/edit");
        //TODO
    }
}
