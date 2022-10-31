package com.nico.portfolio.dto;


public class dtoBody {
    private String sobreMi;
    private String url_foto;
    
    //Constructores

    public dtoBody() {
    }

    public dtoBody(String sobreMi, String url_foto) {
        this.sobreMi = sobreMi;
        this.url_foto = url_foto;
    }
    //Getters and Setters

    public String getSobreMi() {
        return sobreMi;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setSobreMi(String sobreMi) {
        this.sobreMi = sobreMi;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }
    
    
}
