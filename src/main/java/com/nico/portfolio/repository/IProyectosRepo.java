package com.nico.portfolio.repository;

import com.nico.portfolio.model.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectosRepo extends JpaRepository<Proyectos, Integer> {

    public Optional<Proyectos> findByNombreP(String nombreP);

    public boolean existsByNombreP(String nombreP);
}
