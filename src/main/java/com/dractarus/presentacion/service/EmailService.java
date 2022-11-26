package com.dractarus.presentacion.service;

import com.dractarus.presentacion.entity.Email;
import com.dractarus.presentacion.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final EmailRepository emailRepository;

    public void save(Email email) {
        emailRepository.save(email);
    }

    public List<Email> findAll() {
        return emailRepository.findAll();
    }

    public Optional<Email> findById(String id) {
        return emailRepository.findById(id);

    }
    public void deleteById(String id) {
        emailRepository.deleteById(id);

    }
}
