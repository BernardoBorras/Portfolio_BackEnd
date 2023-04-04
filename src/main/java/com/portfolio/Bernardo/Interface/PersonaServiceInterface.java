package com.portfolio.Bernardo.Interface;

import com.portfolio.Bernardo.Entity.Persona;

import java.util.List;

public interface PersonaServiceInterface {
    //Traer una persona
    public List<Persona> getPersona();

    // Guardar un objeto de tipo persona.
    // Como paramtro, enviamos un objeto de tipo persona.
    public void savePersona(Persona persona);

    // Eliminar un objeto, buscandolo por su ID
    public void deletePersona(Long id);

    // Buscar una persona por ID
    public Persona findPersona(Long id);

}
