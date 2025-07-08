package com.healthtrack.model;


public class Usuario {
    private String nombre;
    private double peso;

    public Usuario() {
        // Constructor vacío requerido por Spring MVC para los formularios
    }

    public Usuario(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso < 0) {
            throw new IllegalArgumentException("El peso no puede ser negativo.");
        }
        this.peso = peso;
    }

    public void actualizarPeso(double nuevoPeso) {
        setPeso(nuevoPeso); // Reutiliza la lógica de validación
    }
}
