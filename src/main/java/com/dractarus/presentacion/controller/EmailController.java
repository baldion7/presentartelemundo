package com.dractarus.presentacion.controller;

import com.dractarus.presentacion.entity.Email;
import com.dractarus.presentacion.service.EmailService;
import com.dractarus.presentacion.service.UserDescargasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.activation.URLDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.util.List;
import java.util.Properties;


@RestController
@RequestMapping("/Contacto")
public class EmailController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/New")
    public ModelAndView save(Email request, ModelMap model) throws MessagingException {
        emailService.save(request);
        Properties propiedades = new Properties();
        propiedades.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedades.setProperty("mail.smtp.starttls.enable", "true");
        propiedades.setProperty("mail.smtp.port", "587");
        propiedades.setProperty("mail.smtp.auth", "true");
        Session sesion = Session.getDefaultInstance(propiedades);
        String urlImagen = "https://i0.wp.com/mycielo.org/wp-content/uploads/2020/10/telemundo-logo.png?ssl=1";
        BodyPart texto = new MimeBodyPart();
        String htmlText = "<body><div style='font-size:1.2em; padding-bottom: 10px;border-bottom: 1px solid #123456;'><img src=" + urlImagen + " style='height: 100px'/></div><div style='margin:20px; font-size:0.9em;'><p>Hola, " + request.getNombre() + "</p><p>Gracias por contactarte con nosotros.</p><p>Tu solicitud fue recibida y guardada en nuestra base de datos, proximamente nuestro equipo la revisara y se contactara contigo para darate la respectiva respuesta.</p><p>Un saludo.</p><p>El equipo de Telemundo.</p></div></body>";

        texto.setContent(htmlText, "text/html");

        BodyPart adjuntos = new MimeBodyPart();


        MimeMultipart partes = new MimeMultipart();
        partes.addBodyPart(texto);

        MimeMessage message = new MimeMessage(sesion);
        message.setFrom(new InternetAddress("baldionkevin8@gmail.com"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(request.getCorreo()));
        message.setSubject(request.getAsunto());
        message.setContent(partes);
        Transport transporte = sesion.getTransport("smtp");
        transporte.connect("baldionkevin8@gmail.com","wpwihswsrmbzaabo");
        transporte.sendMessage(message , message.getRecipients(Message.RecipientType.TO));
        transporte.close();
        return new ModelAndView("redirect:/", model);
    }

    @GetMapping("/Listar")
    public List<Email> findAll() {
        return emailService.findAll();
    }





}