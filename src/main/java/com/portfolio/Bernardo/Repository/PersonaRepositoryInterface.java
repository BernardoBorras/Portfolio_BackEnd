package com.portfolio.Bernardo.Repository;

import com.portfolio.Bernardo.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepositoryInterface extends JpaRepository<Persona,Long> {


}
