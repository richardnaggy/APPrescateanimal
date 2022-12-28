package edu.polotic.rescateanimal.repositorios;

import edu.polotic.rescateanimal.entidades.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepositorio extends CrudRepository<Animal, Long> {
    
}
