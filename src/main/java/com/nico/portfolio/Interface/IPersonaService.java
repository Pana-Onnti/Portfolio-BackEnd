package com.nico.portfolio.Interface;

import com.nico.portfolio.model.Persona;
import java.util.List;

public interface IPersonaService {
     //Traer una lista de personas
    public List<Persona>getPersona();
    
    //Guardar un objeto tipo persona
    public void savePersona(Persona persona);
    
    //Eliminar un objeto pero lo buscamos por id
    public void deletePersona(Long id);
    
    //buscamos una persona por id
    public Persona findPersona(Long id);
}
