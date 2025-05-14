package com.cursosalura.aplicaciondecomprastarjetas.modelos;
import com.cursosalura.aplicaciondecomprastarjetas.enumeradores.EstadoTransaccion;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("FieldMayBeFinal")
public class Transaccion {
    private double monto;
    private String descripcion;
    private EstadoTransaccion estado;

    public Transaccion (double monto, String descripcion, EstadoTransaccion estado) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public double getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EstadoTransaccion getEstado() {
        return estado;
    }

    public String FechaTransaccionActualFormateada() {
        LocalDateTime fechaProducto = LocalDateTime.now();
        // Formateador con el patrón deseado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        // Aplicar el formato a la fecha
        return fechaProducto.format(formatter);
    }
}
