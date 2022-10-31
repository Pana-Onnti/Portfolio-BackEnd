package com.nico.portfolio.dto;

public class dtoProyectos {

    private String nombreP;
    private String descripcionP;

    //Constructores
    public dtoProyectos() {
    }

    public dtoProyectos(String nombreP, String descripcionP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
    }

    //Getters and Setters
    public String getNombreP() {
        return nombreP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

}
