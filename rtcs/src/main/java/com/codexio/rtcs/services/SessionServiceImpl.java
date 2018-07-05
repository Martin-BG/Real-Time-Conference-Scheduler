package com.codexio.rtcs.services;

import com.codexio.rtcs.repositories.SessionRepository;
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
