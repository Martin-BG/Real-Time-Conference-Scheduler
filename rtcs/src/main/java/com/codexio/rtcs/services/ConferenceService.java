package com.codexio.rtcs.services;

import com.codexio.rtcs.models.binding.ConferenceCreateBindingDto;
import com.codexio.rtcs.models.view.ConferenceViewDto;

public interface ConferenceService {

    ConferenceViewDto create(ConferenceCreateBindingDto conferenceCreateBindingDto);
}
