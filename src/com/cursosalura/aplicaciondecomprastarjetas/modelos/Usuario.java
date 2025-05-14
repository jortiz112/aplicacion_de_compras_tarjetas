package com.cursosalura.aplicaciondecomprastarjetas.modelos;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("FieldMayBeFinal")
public class Usuario extends Persona {
    private List<TarjetaCredito> tarjetas;

    public Usuario(String nombre, String correo) {
        super(nombre, correo);
        this.tarjetas = new ArrayList<>();
    }

    public List<TarjetaCredito> getTarjetas() {
        return tarjetas;
    }

    public void agregarTarjeta(TarjetaCredito tarjeta) {
        tarjetas.add(tarjeta);
    }
}
