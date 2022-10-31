package com.nico.portfolio.service;

import com.nico.portfolio.model.Body;
import com.nico.portfolio.repository.IBodyRep;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BodyServ {
    @Autowired
    IBodyRep iBodyRep;
    
    public List<Body> list() {
        return iBodyRep.findAll();
    }

    public Optional<Body> getOne(int id) {
        return iBodyRep.findById(id);
    }

    public Optional<Body> getByMySobreMi(String sobreMi) {
        return iBodyRep.findBySobreMi(sobreMi);
    }
    
     public void save(Body body){
        iBodyRep.save(body);
    }
     
    public void delete(int id){
        iBodyRep.deleteById(id);
    }
    
        
    public boolean existsById(int id){
        return iBodyRep.existsById(id);
    }
    
    public boolean existsBySobreMi(String sobreMi){
        return iBodyRep.existsBySobreMi(sobreMi);
    }
             
            
}
