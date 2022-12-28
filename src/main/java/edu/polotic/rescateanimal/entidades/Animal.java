package edu.polotic.rescateanimal.entidades;

import javax.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_animal;

    
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;
    private String especie;
    private String texto;

}
