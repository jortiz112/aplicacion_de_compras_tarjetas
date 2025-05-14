package com.cursosalura.aplicaciondecomprastarjetas.servicios;

import com.cursosalura.aplicaciondecomprastarjetas.modelos.Usuario;

import java.util.Scanner;

public class ServicioUsuario {
    public static Usuario crearUsuarioDesdeConsola(Scanner teclado) {
        //Creación del usuario
        System.out.println("\033[93mPor Favor ingrese el nombre de la persona que realizará las compras:");
        String nombre = teclado.nextLine();
        System.out.println("Por favor ingrese el correo electrónico:");
        String correo = teclado.nextLine();

        return new Usuario(nombre, correo);
    }
}
