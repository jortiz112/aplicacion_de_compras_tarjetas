package com.cursosalura.aplicaciondecomprastarjetas.servicios;

import com.cursosalura.aplicaciondecomprastarjetas.enumeradores.EstadoTransaccion;
import com.cursosalura.aplicaciondecomprastarjetas.modelos.TarjetaCredito;
import com.cursosalura.aplicaciondecomprastarjetas.modelos.Usuario;

import java.util.Scanner;

public class ServicioCompra {

    public static void procesarCompras(Scanner teclado, Usuario usuario) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n\033[93mPor favor ingrese descripción de la compra:");
            String descripcion = teclado.nextLine();
            System.out.println("\033[93mPor favor ingrese el monto de la compra: ");
            double monto = teclado.nextDouble();
            // Se necesita la siguiente línea para limpiar buffer
            teclado.nextLine();

            boolean aprobada = false;
            //Recorro la lista de tarjetas que esta en la clase Usuario
            for (TarjetaCredito tarjeta : usuario.getTarjetas()) {
                //Sé verífica que el saldo disponible de la tarjeta sea mayor o igual al monto de la compra que se realiza
                if (tarjeta.autorizarCompra(tarjeta, monto)) {
                    /*Se realiza la compra comparando el saldo disponible de la tarjeta con el monto de la compra,
                     se le asigna un estado del enumerador y se añade la transacción a la lista de transacciones
                     de la clase TarjetaCredito y retorna el estado de la transacción
                     */
                    EstadoTransaccion estado = tarjeta.realizarCompra(monto, descripcion);
                    //Mensaje final con el estado de la transacción final y la tarjeta que fue utilizada para la compra
                    if (estado == EstadoTransaccion.APROBADA) {
                        System.out.println("✅ \033[97mCompra aprobada con tarjeta " + "\033[95m" + tarjeta.getNumeroTarjeta());
                        aprobada = true;
                        break;
                    } else if (estado == EstadoTransaccion.PENDIENTE) {
                        System.out.println("⚠️ \033[97mCompra pendiente con tarjeta " + "\033[95m" + tarjeta.getNumeroTarjeta());
                    }
                } else {
                    System.err.println("❌ Compra rechazada por tarjeta " + tarjeta.getNumeroTarjeta() +
                            " (Saldo insuficiente o monto inválido)");
                }
            }
            //Mensaje en caso de que ninguna tarjeta tenga saldo suficiente para la compra
            if (!aprobada) {
                System.out.println("❗\033[91mLa compra no pudo ser aprobada con ninguna tarjeta.");
            }

            System.out.println("\033[96m¿Desea realizar otra compra? (s/n):");
            continuar = teclado.nextLine().equalsIgnoreCase("s");
        }
    }
}
