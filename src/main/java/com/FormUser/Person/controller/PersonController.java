package com.FormUser.Person.controller;


import com.FormUser.Person.domain.entities.Person;
import com.FormUser.Person.mediator.CreatePersonCommand;
import com.FormUser.Person.mediator.Mediator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {

    private final Mediator mediator;

    public PersonController(Mediator mediator) {
        this.mediator = mediator;
    }

    // Capturar datos

    @GetMapping("/abrir")
    public String abrirE(Model model){
        Person obj=new Person();
        model.addAttribute("persona",obj);
        return "formulario";
    }

    // Enviar datos
    @PostMapping("/registrar")
    public String registrar(Model model, Person person){
        mediator.sendCommand(new CreatePersonCommand(person));
        return "formulario";
    }

}
