package com.nico.portfolio.service;

import com.nico.portfolio.model.Educacion;
import com.nico.portfolio.repository.IEducacionRep;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {

    @Autowired
    IEducacionRep iEducacionRep;

    public List<Educacion> list() {
        return iEducacionRep.findAll();
    }

    public Optional<Educacion> getOne(int id) {
        return iEducacionRep.findById(id);
    }

    public Optional<Educacion> getByMyNombreEdu(String nombreEdu) {
        return iEducacionRep.findByNombreEdu(nombreEdu);
    }

    public void save(Educacion edu) {
        iEducacionRep.save(edu);
    }

    public void delete(int id) {
        iEducacionRep.deleteById(id);
    }

    public boolean existsById(int id) {
        return iEducacionRep.existsById(id);
    }

    public boolean existsByNombreEdu(String nombreEdu){
        return iEducacionRep.existsByNombreEdu(nombreEdu);
    }

}
