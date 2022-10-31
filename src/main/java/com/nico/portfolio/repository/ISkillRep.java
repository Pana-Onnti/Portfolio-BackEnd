package com.nico.portfolio.repository;

import com.nico.portfolio.model.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillRep extends JpaRepository<Skill, Integer>{
    public Optional<Skill>findByNombreS(String nombreS);
    public boolean existsByNombreS(String nombreS);
}
