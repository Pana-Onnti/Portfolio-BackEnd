package com.nico.portfolio.repository;

import com.nico.portfolio.model.Body;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBodyRep extends JpaRepository<Body,Integer>{
    public Optional<Body> findBySobreMi(String sobreMi);
    public boolean existsBySobreMi(String sobreMi);
    
}
