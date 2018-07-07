package com.codexio.rtcs.repositories;

import com.codexio.rtcs.entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceRepository extends JpaRepository<Conference, String> {

}
