package com.codexio.rtcs.service;

import com.codexio.rtcs.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class HallServiceImpl implements HallService {

    private final HallRepository hallRepository;

    @Autowired
    public HallServiceImpl(final HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }
}