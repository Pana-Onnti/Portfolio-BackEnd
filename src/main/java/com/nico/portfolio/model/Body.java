
package com.nico.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Body {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sobreMi;
    private String url_foto;
    
    //Constructores

    public Body() {
    }

    public Body(String sobreMi, String url_foto) {
        this.sobreMi = sobreMi;
        this.url_foto = url_foto;
    }
    //Getters and Setters

    public int getId() {
        return id;
    }

    public String getSobreMi() {
        return sobreMi;
    }

    public String getUrl_Foto() {
        return url_foto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSobreMi(String sobreMi) {
        this.sobreMi = sobreMi;
    }

    public void setUrl_Foto(String url_foto) {
        this.url_foto = url_foto;
    }
    
    
}
