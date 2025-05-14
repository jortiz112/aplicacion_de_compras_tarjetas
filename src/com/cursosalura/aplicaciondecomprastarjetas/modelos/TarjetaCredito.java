package com.cursosalura.aplicaciondecomprastarjetas.modelos;

import com.cursosalura.aplicaciondecomprastarjetas.enumeradores.EstadoTransaccion;
import com.cursosalura.aplicaciondecomprastarjetas.servicios.ServicioAutorizacionCompra;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"FieldMayBeFinal", "unused"})
public class TarjetaCredito implements ServicioAutorizacionCompra {
    private String numeroTarjeta;
    private String titular;
    private double cupoTotal;
    private double cupoDisponible;
    private LocalDate fechaExpiracion;
    private List<Transaccion> transacciones;

    public TarjetaCredito (String numeroTarjeta, String titular, double cupoTotal,
                           LocalDate fechaExpiracion) {
        this.numeroTarjeta = numeroTarjeta;
        this.titular = titular;
        this.cupoTotal = cupoTotal;
        this.cupoDisponible = cupoTotal;
        this.fechaExpiracion = fechaExpiracion;
        this.transacciones = new ArrayList<>();
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getTitular() {
        return titular;
    }

    public double getCupoTotal() {
        return cupoTotal;
    }

    public double getCupoDisponible() {
        return cupoDisponible;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    @Override
    public boolean autorizarCompra(TarjetaCredito tarjeta, double monto) {
        return tarjeta.getCupoDisponible() >= monto && monto > 0;
    }

    public EstadoTransaccion realizarCompra(double monto, String descripcion) {
        EstadoTransaccion estado;
        if (monto <= 0) {
            estado = EstadoTransaccion.PENDIENTE;
        } else if (monto <= cupoDisponible) {
            cupoDisponible -= monto; //cálculo el saldo disponible después de la compra
            estado = EstadoTransaccion.APROBADA;
        } else {
            estado = EstadoTransaccion.RECHAZADA;
        }

        Transaccion transaccion = new Transaccion(monto, descripcion, estado);
        transacciones.add(transaccion);
        return estado;
    }

}
