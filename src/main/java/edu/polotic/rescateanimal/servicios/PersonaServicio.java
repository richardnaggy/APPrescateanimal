package edu.polotic.rescateanimal.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.polotic.rescateanimal.repositorios.PersonaRepositorio;

@Service
public class PersonaServicio {

    @Autowired
    PersonaRepositorio personaRepositorio;

}
