package com.nico.portfolio.service;

import com.nico.portfolio.model.Experiencia;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nico.portfolio.repository.IExperienciaRep;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExperienciaService {
    @Autowired
    IExperienciaRep iExperienciaRep;
    
    public List<Experiencia> list(){
        return iExperienciaRep.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return iExperienciaRep.findById(id);
    }
    
    public Optional<Experiencia> getByMyNombreExp(String nombreExp){
        return iExperienciaRep.findByNombreExp(nombreExp);
    } 
    
    public void save(Experiencia exp){
        iExperienciaRep.save(exp);
    }
    
    public void delete(int id){
        iExperienciaRep.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iExperienciaRep.existsById(id);
    }
    
    public boolean exisysByNombreExp(String nombreExp){
        return iExperienciaRep.existsByNombreExp(nombreExp);
    }
    
}
