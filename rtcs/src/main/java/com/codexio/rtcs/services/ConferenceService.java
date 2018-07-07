package com.codexio.rtcs.services;

import com.codexio.rtcs.models.binding.ConferenceCreateBindingDto;
import com.codexio.rtcs.models.view.ConferenceViewDto;
import com.codexio.rtcs.models.view.SessionViewDto;

import java.time.LocalDate;
import java.util.Collection;

public interface ConferenceService {

    ConferenceViewDto create(ConferenceCreateBindingDto conferenceCreateBindingDto);

    Collection<ConferenceViewDto> getAll();

    Collection<ConferenceViewDto> getAllUpcomingByDate(LocalDate date);

    Collection<SessionViewDto> getSessions(String id);
}
