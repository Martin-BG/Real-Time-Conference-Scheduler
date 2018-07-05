package com.codexio.rtcs.services;

import com.codexio.rtcs.repositories.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ConferenceServiceImpl implements ConferenceService {

    private final ConferenceRepository conferenceRepository;

    @Autowired
    public ConferenceServiceImpl(final ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }
}
