package com.nico.portfolio.controller;

import com.nico.portfolio.dto.dtoBody;
import com.nico.portfolio.model.Body;
import com.nico.portfolio.security.Controller.Mensaje;
import com.nico.portfolio.service.BodyServ;
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
@RequestMapping("body")
@CrossOrigin(origins = "https://portfolio-42ec5.web.app")
public class BodyController {
    @Autowired
    BodyServ bodyServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Body>> list() {
        List<Body> list = bodyServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Body> getById(@PathVariable("id") int id) {
        if (!bodyServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }

        Body body = bodyServ.getOne(id).get();
        return new ResponseEntity(body, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!bodyServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        bodyServ.delete(id);
        return new ResponseEntity(new Mensaje("body eliminada"), HttpStatus.OK);
    }
        
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoBody dtobody) {
        if (StringUtils.isBlank(dtobody.getSobreMi())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (bodyServ.existsBySobreMi(dtobody.getSobreMi())) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        Body body = new Body(
                dtobody.getSobreMi(), dtobody.getUrl_foto()
        );
        bodyServ.save(body);
        return new ResponseEntity(new Mensaje("body creada"), HttpStatus.OK);

    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoBody dtobody) {
        if (!bodyServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (bodyServ.existsBySobreMi(dtobody.getSobreMi()) && bodyServ.getByMySobreMi(dtobody.getSobreMi()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtobody.getSobreMi())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        Body body = bodyServ.getOne(id).get();

        body.setSobreMi(dtobody.getSobreMi());
        body.setUrl_Foto(dtobody.getUrl_foto());

        bodyServ.save(body);

        return new ResponseEntity(new Mensaje("cosa actualizada"), HttpStatus.OK);
    }
}
