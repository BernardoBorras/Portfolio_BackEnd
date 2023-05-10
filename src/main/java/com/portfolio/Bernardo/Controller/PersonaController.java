package com.portfolio.Bernardo.Controller;


import com.portfolio.Bernardo.Entity.Persona;
import com.portfolio.Bernardo.Interface.PersonaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://frontend-97f9c.web.app")
public class PersonaController {
    @Autowired PersonaServiceInterface personaServiceInterface;

    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return personaServiceInterface.findPersona((long)1);
    }

    // getmapping es para que nos traiga de la BD al front (hablando mal y pronto)
    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return personaServiceInterface.getPersona();
    }
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        personaServiceInterface.savePersona(persona);
        return "persona creada exitosamente";
    }
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        personaServiceInterface.deletePersona(id);
    return "Persona eliminada con exito";
    }


   //  Si quiero editar un usuario ya creado.
   //  La url va quedar de la siguiente manera.
   //  URL:PUERTO/personas/editar/4/nombre,apellido,img
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("img") String nuevoImg){

    // primero buscamos a la persona y luego la almacenamos en la variable "id"
        Persona persona = personaServiceInterface.findPersona(id);

    // Estos getters y setters se encuentran creados por la libreria de Lombok
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);

    // Le decimos que guarde el objeto persona por medio de un objeto de la clase "personaServiceInterface"
        personaServiceInterface.savePersona(persona);
        return persona;
    }
}
