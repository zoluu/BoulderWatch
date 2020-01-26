package com.boulderwatch.web;

import com.boulderwatch.persistence.model.Session;
import com.boulderwatch.persistence.repo.SessionRepository;
import com.boulderwatch.web.exception.SessionIDMismatchException;
import com.boulderwatch.web.exception.SessionNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public Iterable findAll() {
        return sessionRepository.findAll();
    }

    @GetMapping("/name/{boulderName}")
    public List findByName(@PathVariable String boulderName) {
        return sessionRepository.findByName(boulderName);
    }

    @GetMapping("/{id}")
    public Session findOne(@PathVariable Long id) {
        return sessionRepository.findById(id).orElseThrow(SessionNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Session create(@RequestBody Session session) {
        return sessionRepository.save(session);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sessionRepository.findById(id).orElseThrow(SessionNotFoundException::new);
        sessionRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Session updateBoulder(@RequestBody Session session, @PathVariable Long id) {
        if (session.getId() != id) {
            throw new SessionIDMismatchException();
        }
        sessionRepository.findById(id).orElseThrow(SessionNotFoundException::new);
        return sessionRepository.save(session);
    }

}
