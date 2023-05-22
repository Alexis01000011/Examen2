package mx.com.ingsoft.adoo.examen.programa;

import mx.com.ingsoft.adoo.examen.entidades.Administrador;
import mx.com.ingsoft.adoo.examen.entidades.Participante;

import java.util.Scanner;

public class MainPrograma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("¡Bienvenido al sistema de Reunion de Egresados!");
        System.out.println("");
        System.out.println("Primero, identificate.\n¿Que tipo de usuario eres?");
        System.out.println("1. Participante.\n2. Administrador.\n3. Salir.");
        System.out.println("*** Escribe la opcion (1 - 3) ***");
        int option = sc.nextInt();
        boolean menuPrograma = true;

        while (menuPrograma){
            if (option == 1){
                Participante.enviaDatosRegistro();
                menuPrograma = false;
            } else if (option == 2){
                //PASSWORD DE ADMIN = ""
                Administrador.menuAdmin();
                menuPrograma = false;
            } else if (option == 3){
                System.out.println("¡Hasta luego!");
                menuPrograma = false;
            }
        }
    }
}
