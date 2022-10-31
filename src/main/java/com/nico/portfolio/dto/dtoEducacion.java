package com.nico.portfolio.dto;


public class dtoEducacion {
    private String nombreEdu;
    private String descripcionEdu;
    
    //Constructores
    public dtoEducacion(){
        
    }

    public dtoEducacion(String nombreEdu, String descripcionEdu) {
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
    }
    
    //Getters and Setters

    public String getNombreEdu() {
        return nombreEdu;
    }

    public String getDescripcionEdu() {
        return descripcionEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public void setDescripcionEdu(String descripcionEdu) {
        this.descripcionEdu = descripcionEdu;
    }

}
