package com.boulderwatch.persistence.repo;

import com.boulderwatch.persistence.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findByName(String name);
}
