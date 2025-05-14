package com.cursosalura.aplicaciondecomprastarjetas.modelos;

@SuppressWarnings({"FieldMayBeFinal", "unused"})

public abstract class Persona {
    private String nombre;
    private String correo;

    public Persona (String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }
}
