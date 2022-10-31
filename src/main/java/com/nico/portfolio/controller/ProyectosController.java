package com.nico.portfolio.controller;

import com.nico.portfolio.dto.dtoProyectos;
import com.nico.portfolio.model.Proyectos;
import com.nico.portfolio.security.Controller.Mensaje;
import com.nico.portfolio.service.ProyectosService;
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
@RequestMapping("pro")
@CrossOrigin(origins="https://portfolio-42ec5.web.app")
public class ProyectosController {
     @Autowired
     ProyectosService proyectoServ;
     
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = proyectoServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
     
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id) {
        if (!proyectoServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Proyectos proyecto = proyectoServ.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
     
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!proyectoServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        proyectoServ.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoPRO) {
        if (StringUtils.isBlank(dtoPRO.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (proyectoServ.existsByNombreP(dtoPRO.getNombreP())) {
            return new ResponseEntity(new Mensaje("Esa proyecto existe"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyecto = new Proyectos(dtoPRO.getNombreP(), dtoPRO.getDescripcionP());
        proyectoServ.save(proyecto);

        return new ResponseEntity(new Mensaje("Proyecto guardado"), HttpStatus.OK);
    }
     
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoPRO) {
        //Validamos si existe el ID
        if (!proyectoServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de experiencias
        if (proyectoServ.existsByNombreP(dtoPRO.getNombreP()) && proyectoServ.getByMyNombreP(dtoPRO.getNombreP()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        //Validamos nombre
        if (StringUtils.isBlank(dtoPRO.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyecto = proyectoServ.getOne(id).get();
        proyecto.setNombreP(dtoPRO.getNombreP());
        proyecto.setDescripcionP(dtoPRO.getDescripcionP());

        proyectoServ.save(proyecto);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }

     
}
