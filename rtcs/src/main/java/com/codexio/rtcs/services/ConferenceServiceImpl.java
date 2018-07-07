package com.codexio.rtcs.services;

import com.codexio.rtcs.entities.Conference;
import com.codexio.rtcs.entities.Session;
import com.codexio.rtcs.entities.User;
import com.codexio.rtcs.models.binding.ConferenceCreateBindingDto;
import com.codexio.rtcs.models.view.ConferenceViewDto;
import com.codexio.rtcs.models.view.SessionViewDto;
import com.codexio.rtcs.repositories.ConferenceRepository;
import com.codexio.rtcs.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

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

    @Override
    public Collection<ConferenceViewDto> getAll() {
        return conferenceRepository
                .findAll()
                .stream()
                .map(conference -> {
                    final ConferenceViewDto conferenceViewDto = modelMapper.map(conference, ConferenceViewDto.class);
                    conferenceViewDto.setUserEmail(conference.getOwner().getEmail());
                    return conferenceViewDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Collection<ConferenceViewDto> getAllUpcomingByDate(final LocalDate date) {
        return conferenceRepository
                .findAll()
                .stream()
                .filter(conference -> conference.getEndDate().isAfter(date))
                .map(conference -> {
                    final ConferenceViewDto conferenceViewDto = modelMapper.map(conference, ConferenceViewDto.class);
                    conferenceViewDto.setUserEmail(conference.getOwner().getEmail());
                    return conferenceViewDto;
                })
                .sorted(Comparator.comparing(ConferenceViewDto::getStartDate))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<SessionViewDto> getSessions(final String id) {
        final Conference conference = conferenceRepository.getOne(id);
        return conference
                .getSessions()
                .stream()
                .sorted(Comparator.comparing(Session::getStartTime))
                .map(session -> {
                    final SessionViewDto sessionViewDto = modelMapper.map(session, SessionViewDto.class);
                    sessionViewDto.setHallId(session.getHall().getId());
                    sessionViewDto.setHallName(session.getHall().getName());
                    sessionViewDto.setAttendancesCount(session.getAttendances().size());
                    sessionViewDto.setConferenceName(conference.getName());
                    sessionViewDto.setConferenceId(conference.getId());
                    return sessionViewDto;
                })
                .collect(Collectors.toList());
    }
}
