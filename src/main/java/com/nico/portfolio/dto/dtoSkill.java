package com.nico.portfolio.dto;

public class dtoSkill {

    private String nombreS;
    private int percent;
    private String url_foto;

    //Constructores
    public dtoSkill() {
    }

    public dtoSkill(String nombreS, int percent, String url_foto) {
        this.nombreS = nombreS;
        this.percent = percent;
        this.url_foto = url_foto;
    }

    //Getters and Setters
    public String getNombreS() {
        return nombreS;
    }

    public int getPercent() {
        return percent;
    }

    public String getUrl_foto() {
        return url_foto;
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
