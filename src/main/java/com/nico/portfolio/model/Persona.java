package com.nico.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min=1, max=50, message="no cumple con la longitud")
    private String nombre;
    @NotNull
    @Size(min=1, max=50, message="no cumple con la longitud")
    private String apellido;
    @NotNull
    @Size(min=1, max=50, message="no cumple con la longitud")
    private String url_foto;
    
    public Persona(){}

    public Persona(Long id, String nombre, String apellido, String url_foto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.url_foto = url_foto;
    }
}
