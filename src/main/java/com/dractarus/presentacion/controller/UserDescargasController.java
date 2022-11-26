package com.dractarus.presentacion.controller;


import com.dractarus.presentacion.entity.UserDescargas;
import com.dractarus.presentacion.service.UserDescargasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/Formulario")

public class UserDescargasController {
    @Autowired
    private  UserDescargasService userDescargasService;

    @PostMapping("/New")
    public ModelAndView save(UserDescargas request, ModelMap model) {

        userDescargasService.save(request);
        return new ModelAndView("redirect:/Descarga", model);
    }
    @GetMapping("/Listar")
    public List<UserDescargas> findAll() {
        return userDescargasService.findAll();
    }




}

