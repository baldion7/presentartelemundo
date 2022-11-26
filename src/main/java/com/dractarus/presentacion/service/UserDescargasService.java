package com.dractarus.presentacion.service;


import com.dractarus.presentacion.entity.UserDescargas;
import com.dractarus.presentacion.repository.UserDescargasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserDescargasService {
    private final UserDescargasRepository userDescargasRepository;
    public void save(UserDescargas userDescargas) {
        userDescargasRepository.save(userDescargas);
    }
    public List<UserDescargas> findAll(){
        return userDescargasRepository.findAll();
    }
    public Optional<UserDescargas> findById(String id){
        return userDescargasRepository.findById(id);

    }
    public void deleteById(String id){
        userDescargasRepository.deleteById(id);
    }
}
