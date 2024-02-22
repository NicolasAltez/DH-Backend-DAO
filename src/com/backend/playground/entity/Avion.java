package com.backend.playground.entity;

import java.time.LocalDate;

public class Avion {
    private int id;
    private String marca;
    private String modelo;
    private String matricula;
    private LocalDate fechaEntradaServicio;
    public Avion(String marca, String modelo, String matricula, LocalDate fechaEntradaServicio) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.fechaEntradaServicio = fechaEntradaServicio;
    }

    public Avion(int id, String marca, String modelo, String matricula, LocalDate fechaEntradaServicio) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.fechaEntradaServicio = fechaEntradaServicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getFechaEntradaServicio() {
        return fechaEntradaServicio;
    }

    public void setFechaEntradaServicio(LocalDate fechaEntradaServicio) {
        this.fechaEntradaServicio = fechaEntradaServicio;
    }

    //TODO METODO NECESARIO PARA MOSTRAR LOS DATOS DE UN AVION SI ES NECESARIO EN UN LOG
    @Override
    public String toString() {
        return "Avion{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", fechaEntradaServicio=" + fechaEntradaServicio +
                '}';
    }
}
