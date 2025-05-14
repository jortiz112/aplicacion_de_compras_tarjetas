package com.cursosalura.aplicaciondecomprastarjetas.servicios;

import com.cursosalura.aplicaciondecomprastarjetas.modelos.TarjetaCredito;
import com.cursosalura.aplicaciondecomprastarjetas.modelos.Usuario;

import java.time.LocalDate;
import java.util.Scanner;

public class ServicioTarjeta {

    public static void registrarTarjetasParaUsuario(Scanner teclado, Usuario usuario) {
        System.out.println("\033[93m¿Por favor ingrese cuantas tarjetas desea registrar?:");
        int cantidadTarjetas = teclado.nextInt();
        // Se necesita la siguiente línea para limpiar buffer
        teclado.nextLine();

        for (int i = 1; i <= cantidadTarjetas; i++) {
            System.out.println("\n\033[92m=== \033[95mTarjeta #" + i + " \033[92m===");

            System.out.println("\033[93mPor favor ingrese el número de tarjeta:");
            String numero = teclado.nextLine();

            System.out.println("Por favor ingrese el nombre del titular de la tarjeta:");
            String titular = teclado.nextLine();

            System.out.println("Por favor ingrese el cupo total de la tarjeta de crédito:");
            double cupo = teclado.nextDouble();
            // Se necesita la siguiente línea para limpiar buffer
            teclado.nextLine();
            System.out.println("Por favor ingrese la fecha de expiración de la tarjeta (yyyy-MM-dd):");
            String fechaStr = teclado.nextLine();
            /*Convierte (parse) el string de la fecha al tipo de dato LocalDate,
              pero solo acepta el formato anterior (yyyy-MM-dd) */
            LocalDate fechaExpiracion = LocalDate.parse(fechaStr);

            TarjetaCredito tarjeta = new TarjetaCredito(numero, titular, cupo, fechaExpiracion);
            usuario.agregarTarjeta(tarjeta);
        }
    }
}
