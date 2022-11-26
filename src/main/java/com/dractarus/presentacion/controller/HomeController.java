package com.dractarus.presentacion.controller;

import com.dractarus.presentacion.entity.Email;
import com.dractarus.presentacion.entity.UserDescargas;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("request", new UserDescargas());
        return "Index";
    }
    @GetMapping("/Descarga")
    public String Descarga(Model model) {
        model.addAttribute("request", new UserDescargas());
        return "Descarga";
    }
    @GetMapping("/Formulario")
    public String Formulario(Model model) {
        model.addAttribute("request", new UserDescargas());
        return "FormDesc";
    }

    @GetMapping("/Funciones")
    public String Funciones(Model model) {
        model.addAttribute("request", new UserDescargas());
        return "Funciones";
    }
    @GetMapping("/Contacto")
    public String Contacto(Model model) {
        model.addAttribute("request", new Email());
        return "Contacto";
    }
}

