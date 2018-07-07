package com.codexio.rtcs.services;

import com.codexio.rtcs.entities.Conference;
import com.codexio.rtcs.entities.User;
import com.codexio.rtcs.models.binding.ConferenceCreateBindingDto;
import com.codexio.rtcs.models.view.ConferenceViewDto;
import com.codexio.rtcs.repositories.ConferenceRepository;
import com.codexio.rtcs.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ConferenceServiceImpl implements ConferenceService {

    private final ConferenceRepository conferenceRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ConferenceServiceImpl(final ConferenceRepository conferenceRepository,
                                 final UserRepository userRepository,
                                 final ModelMapper modelMapper) {
        this.conferenceRepository = conferenceRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    private ConferenceViewDto getConferenceViewDto(final Conference conference) {
        if (conference == null) {
            return null;
        }

        ConferenceViewDto conferenceViewDto = this.modelMapper.map(conference, ConferenceViewDto.class);
        conferenceViewDto.setUserEmail(conference.getOwner().getEmail());
        return conferenceViewDto;
    }

    @Override
    public ConferenceViewDto create(final ConferenceCreateBindingDto conferenceCreateBindingDto) {
        Conference conference = null;

        final User user = userRepository.findByEmail(conferenceCreateBindingDto.getUserEmail());

        if (user != null) {
            conference = modelMapper.map(conferenceCreateBindingDto, Conference.class);
            conference.setOwner(user);
            conferenceRepository.saveAndFlush(conference);
        }

        return this.getConferenceViewDto(conference);
    }

}
