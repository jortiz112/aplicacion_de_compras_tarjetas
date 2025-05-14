package com.cursosalura.aplicaciondecomprastarjetas.main;

import com.cursosalura.aplicaciondecomprastarjetas.modelos.Usuario;
import com.cursosalura.aplicaciondecomprastarjetas.servicios.ServicioCompra;
import com.cursosalura.aplicaciondecomprastarjetas.servicios.ServicioHistorial;
import com.cursosalura.aplicaciondecomprastarjetas.servicios.ServicioTarjeta;
import com.cursosalura.aplicaciondecomprastarjetas.servicios.ServicioUsuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                \033[92m
                ******************************************************************
                💫🌟\033[95mBienvenido al sistema de compras con tarjetas de crédito.🌟💫\033[92m
                ******************************************************************
                """);
        Scanner teclado = new Scanner(System.in);
        //Creación del usuario
        Usuario usuario = ServicioUsuario.crearUsuarioDesdeConsola(teclado);
        //Se agrega al usuario tarjetas de crédito
        ServicioTarjeta.registrarTarjetasParaUsuario(teclado,usuario);
        //Se realiza las compras
        ServicioCompra.procesarCompras(teclado, usuario);
        //Mostrar historial de compras o transacciones por tarjeta
        ServicioHistorial.mostrarHistorialCompras(usuario);
        teclado.close();
    }
}
