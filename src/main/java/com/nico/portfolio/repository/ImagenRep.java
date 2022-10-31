package com.nico.portfolio.repository;

import com.nico.portfolio.model.Imagen;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRep extends JpaRepository<Imagen,Integer>{
    List<Imagen>findByOrderById();
}
