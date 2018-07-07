package com.codexio.rtcs.controllers;

import com.codexio.rtcs.models.binding.ConferenceCreateBindingDto;
import com.codexio.rtcs.models.view.ConferenceViewDto;
import com.codexio.rtcs.services.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("/conferences")
public class ConferencesController extends BaseController {

    private final ConferenceService conferenceService;

    @Autowired
    public ConferencesController(final ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @GetMapping("/all")
    public ModelAndView allGet() {
        ModelAndView modelAndView = super.view("/conferences/all");
        modelAndView.addObject("conferences", conferenceService.getAllUpcomingByDate(LocalDate.now()));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createGet() {
        return super.view("/conferences/create");
    }

    @PostMapping("/create")
    public ModelAndView createPost(@Valid @ModelAttribute ConferenceCreateBindingDto conferenceCreateBindingDto,
                                   BindingResult result) {

        if (!result.hasErrors()) {
            conferenceCreateBindingDto.setUserEmail(SecurityContextHolder.getContext().getAuthentication().getName());
            final ConferenceViewDto conferenceViewDto = conferenceService.create(conferenceCreateBindingDto);

            if (conferenceViewDto != null) {
                return super.redirect("/conferences/edit");
            } else {
                result.rejectValue("persist", "error.create.conference",
                        "Conference creation failed");
            }

        }

        return super.view("/conferences/create");
    }

    @GetMapping("/edit")
    public ModelAndView editGet() {
        return super.view("/conferences/edit");
    }

    @PostMapping("/edit")
    public ModelAndView editPost() {
        return super.view("/conferences/edit");
    }
}
