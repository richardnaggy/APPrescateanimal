package edu.polotic.rescateanimal.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.polotic.rescateanimal.entidades.Persona;

@Repository
public interface PersonaRepositorio extends CrudRepository<Persona, Long> {

}
