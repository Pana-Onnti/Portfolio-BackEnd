package com.nico.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreS;
    private int percent;
    private String url_foto;

    //Constructores

    public Skill() {
    }

    public Skill(String nombreS, int percent, String url_foto) {
        this.nombreS = nombreS;
        this.percent = percent;
        this.url_foto = url_foto;
    }
    
    //Getters and Setters

    public int getId() {
        return id;
    }

    public String getNombreS() {
        return nombreS;
    }

    public int getPercent() {
        return percent;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }
    

}
