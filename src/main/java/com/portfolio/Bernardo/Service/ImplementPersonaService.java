package com.portfolio.Bernardo.Service;

import com.portfolio.Bernardo.Entity.Persona;
import com.portfolio.Bernardo.Interface.PersonaServiceInterface;
import com.portfolio.Bernardo.Repository.PersonaRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplementPersonaService implements PersonaServiceInterface {

    @Autowired
    PersonaRepositoryInterface PersonaRepositoryInterface;
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = PersonaRepositoryInterface.findAll();
        return persona;
    }


    //savePersona recibe por parametro un objeto de tipo persona,
    //
    @Override
    public void savePersona(Persona persona) {
        PersonaRepositoryInterface.save(persona);
    }


    // este metodo recibe el id del usuario a eliminar.
    @Override
    public void deletePersona(Long id) {
        PersonaRepositoryInterface.deleteById(id);

    }


    // este metodo recibe el id del usuario a buscar.
    // una vez encontrado, lo mostramos.
    @Override
    public Persona findPersona(Long id) {
        Persona persona = PersonaRepositoryInterface.findById(id).orElse(null);
        return persona;
    }





}
