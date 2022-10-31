package com.nico.portfolio.service;

import com.nico.portfolio.model.Skill;
import com.nico.portfolio.repository.ISkillRep;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SkillService {

    @Autowired
    ISkillRep iSkillRep;

    public List<Skill> list() {
        return iSkillRep.findAll();
    }

    public Optional<Skill> getOne(int id) {
        return iSkillRep.findById(id);
    }

    public Optional<Skill> getByMyNombreS(String nombreS) {
        return iSkillRep.findByNombreS(nombreS);
    }
    
     public void save(Skill skill){
        iSkillRep.save(skill);
    }
     
    public void delete(int id){
        iSkillRep.deleteById(id);
    }
    
        
    public boolean existsById(int id){
        return iSkillRep.existsById(id);
    }
    
    public boolean existsByNombreS(String nombreS){
        return iSkillRep.existsByNombreS(nombreS);
    }
    

}
