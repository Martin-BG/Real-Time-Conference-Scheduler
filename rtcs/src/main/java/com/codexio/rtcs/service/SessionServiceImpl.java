package com.codexio.rtcs.service;

import com.codexio.rtcs.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;

    @Autowired
    public SessionServiceImpl(final SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }
}
