package com.nico.portfolio.service;

import com.nico.portfolio.model.Proyectos;
import com.nico.portfolio.repository.IProyectosRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectosService {
     @Autowired
     IProyectosRepo iProyectosRep;
     
     public List<Proyectos> list(){
        return iProyectosRep.findAll();
    }
    
    public Optional<Proyectos> getOne(int id){
        return iProyectosRep.findById(id);
    }
    
    public Optional<Proyectos> getByMyNombreP(String nombreP){
        return iProyectosRep.findByNombreP(nombreP);
    } 
    
    public void save(Proyectos p){
        iProyectosRep.save(p);
    }
    
    public void delete(int id){
        iProyectosRep.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iProyectosRep.existsById(id);
    }
    
    public boolean existsByNombreP(String nombreP){
        return iProyectosRep.existsByNombreP(nombreP);
    }
    
     
     
     
     
     
     
     
     
     
}
