package com.cursosalura.aplicaciondecomprastarjetas.servicios;

import com.cursosalura.aplicaciondecomprastarjetas.modelos.TarjetaCredito;
import com.cursosalura.aplicaciondecomprastarjetas.modelos.Transaccion;
import com.cursosalura.aplicaciondecomprastarjetas.modelos.Usuario;

import java.util.Comparator;
import java.util.List;

public class ServicioHistorial {

    public static void mostrarHistorialCompras(Usuario usuario) {

        System.out.println("\n\033[92m======= \033[95mHISTORIAL DE COMPRAS \033[92m=======");

        //Recorre las lista de tarjetas de crédito y revisa si tiene transacciones
        for (TarjetaCredito tarjeta : usuario.getTarjetas()) {
            System.out.println("\n\033[36mTarjeta: " + "\033[35m" + tarjeta.getNumeroTarjeta() +
                    " \033[34m| \033[36mCupo disponible: $" + "\033[35m" + tarjeta.getCupoDisponible());

            List<Transaccion> transacciones = tarjeta.getTransacciones();
            //Verifica si la lista esta vacía
            if (transacciones.isEmpty()) {
                System.out.println("\033[35m- Sin transacciones registradas.");
                /*Aquí saltamos el resto del código siguiente, para pasar directamente
                * a la siguiente iteracción (tarjeta) de la lista de tarjetas*/
                continue;
            }

            //  Ordenar transacciones por el monto de la compra
            transacciones.sort(Comparator.comparing(Transaccion::getMonto));

            for (Transaccion t : tarjeta.getTransacciones()) {
                String fechaFormateada = t.FechaTransaccionActualFormateada();
                System.out.println("\033[92m- " + "\033[95m" + fechaFormateada +
                        " \033[92m| " + "\033[95m" + t.getDescripcion() +
                        " \033[92m| $" + "\033[95m" + t.getMonto() +
                        " \033[92m| Estado: " + "\033[95m" + t.getEstado());
            }
        }

    }
}
