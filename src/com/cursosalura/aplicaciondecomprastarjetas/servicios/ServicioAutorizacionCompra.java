package com.cursosalura.aplicaciondecomprastarjetas.servicios;

import com.cursosalura.aplicaciondecomprastarjetas.modelos.TarjetaCredito;

public interface ServicioAutorizacionCompra {
    boolean autorizarCompra(TarjetaCredito tarjeta, double monto);
}
