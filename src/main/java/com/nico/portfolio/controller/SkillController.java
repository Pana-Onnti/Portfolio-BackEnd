package com.nico.portfolio.controller;

import com.nico.portfolio.dto.dtoSkill;
import com.nico.portfolio.model.Skill;
import com.nico.portfolio.security.Controller.Mensaje;
import com.nico.portfolio.service.SkillService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("skill")
@CrossOrigin(origins = "https://portfolio-42ec5.web.app")
public class SkillController {
    @Autowired
    SkillService skillServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> list() {
        List<Skill> list = skillServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id) {
        if (!skillServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }

        Skill skill = skillServ.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!skillServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        skillServ.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkill dtoskill) {
        if (StringUtils.isBlank(dtoskill.getNombreS())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (skillServ.existsByNombreS(dtoskill.getNombreS())) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        Skill skill = new Skill(
                dtoskill.getNombreS(), dtoskill.getPercent(), dtoskill.getUrl_foto()
        );
        skillServ.save(skill);
        return new ResponseEntity(new Mensaje("Skill creada"), HttpStatus.OK);

    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkill dtoskill) {
        if (!skillServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (skillServ.existsByNombreS(dtoskill.getNombreS()) && skillServ.getByMyNombreS(dtoskill.getNombreS()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa Skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoskill.getNombreS())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        Skill skill = skillServ.getOne(id).get();

        skill.setNombreS(dtoskill.getNombreS());
        skill.setPercent(dtoskill.getPercent());
        skill.setUrl_foto(dtoskill.getUrl_foto());

        skillServ.save(skill);

        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }

    
}
