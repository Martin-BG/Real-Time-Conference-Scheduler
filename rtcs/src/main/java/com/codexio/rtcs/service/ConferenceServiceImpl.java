package com.codexio.rtcs.service;

import com.codexio.rtcs.repository.ConferenceRepository;
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
