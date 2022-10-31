package com.nico.portfolio.dto;

public class dtoExperiencia {

    private String nombreExp;
    private String descripcionExp;

    //Constructores
    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreExp, String descripcionExp) {
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
    }

    //Getters and Setters

    public String getNombreExp() {
        return nombreExp;
    }

    public String getDescripcionExp() {
        return descripcionExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }


}
