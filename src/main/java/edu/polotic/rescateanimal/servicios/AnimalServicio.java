package edu.polotic.rescateanimal.servicios;

import org.springframework.stereotype.Service;

import edu.polotic.rescateanimal.entidades.Animal;
import edu.polotic.rescateanimal.entidades.*;
import edu.polotic.rescateanimal.repositorios.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class AnimalServicio {
    @Autowired
    AnimalRepositorio animalRepositorio;

    public List<Animal> getAll()
    {
        List<Animal> lista = new ArrayList<Animal>();
        animalRepositorio.findAll().forEach(registro -> lista.add(registro));
        return lista;
    }

    public Animal getById(Long id)
    {
        return animalRepositorio.findById(id).get();
    }

    public void save(Animal animal)
    {
        animalRepositorio.save(animal);
    }

    public void delete(Long id)
    {
        animalRepositorio.deleteById(id);
    }
    
}
