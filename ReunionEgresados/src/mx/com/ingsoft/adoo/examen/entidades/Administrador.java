package mx.com.ingsoft.adoo.examen.entidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Administrador {
    private static final String PASSWORD_ADMIN = ""; //PASSWORD DE ADMIN = ""
    private int idAdmin;
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private String email;

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static void menuAdmin(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese su contrasenna de administrador:");
        String password = sc.nextLine();

        if (password.equals(PASSWORD_ADMIN)){
            System.out.println("Bienvenido! Que desea realizar?");
            System.out.println("1. Generar reporte de participantes");
            System.out.println("2. Cambiar fecha límite de registro");
            System.out.println("3. Salir");
            System.out.print("Ingrese el número de la opción que desea ejecutar: ");
            int option = sc.nextInt();
            boolean menu = true;

            while (menu){
                if (option == 1) {
                    generaReporte();
                    menu = false;
                } else if (option == 2) {
                    cambiaFechaLimite();
                    menu = false;
                } else if(option == 3){
                    System.out.println("¡Nos vemos!");
                    menu = false;
                }else {
                    System.out.println("Opción no válida...\n** FINALIZANDO PROGRAMA. **");
                }
                sc.close();
            }
        } else{
            System.out.println("Contrasenna incorrecta...\n** FINALIZANDO PROGRAMA **");
        }
    }
    public static void enviaConfirmacionEmail(){
        System.out.println("¡Los datos se han guardado exitosamente!");
        System.out.println("¡Gracias por enviar tu registro!");
    }

    public static void confirmacionFallida(){
        System.out.println("Ha ocurrido un ERROR al guardar los datos...");
        System.out.println("Por favor, verifica tus datos.\n** FINALIZANDO PROGRAMA **");
    }

    public static void cambiaFechaLimite(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la nueva fecha límite de registro: ");
        String fechaLimiteNueva = sc.nextLine();

        System.out.println("La fecha límite de registro se ha cambiado a: " + fechaLimiteNueva);

        sc.close();
    }

    public static void generaReporte(){
        String archivoCSV = "participantes.csv";
        String archivoTXT = "reporteParticipantes.txt";

        try (FileWriter writer = new FileWriter(archivoTXT)) {
            BufferedReader reader = new BufferedReader(new FileReader(archivoCSV));
            String linea = reader.readLine();

            writer.write("Reporte de Participantes:\n\n");

            while ((linea = reader.readLine()) != null) {
                String[] data = linea.split(",");
                String matricula = data[0];
                String nombre = data[1];
                String aPaterno = data[2];
                String aMaterno = data[3];
                String email = data[4];
                String carrera = data[5];
                String generacion = data[6];
                String institucion = data[7];
                String activo = data[8];

                writer.write("Matricula: " + matricula + "\n");
                writer.write("Nombre: " + nombre + "\n");
                writer.write("Apellido Paterno: " + aPaterno + "\n");
                writer.write("Apellido Materno (opcional): " + aMaterno + "\n");
                writer.write("E-mail: " + email + "\n");
                writer.write("Carrera: " + carrera + "\n");
                writer.write("Generacion: " + generacion + "\n");
                writer.write("Institucion: " + institucion + "\n");
                writer.write("Estado Activo: " + activo + "\n");
                writer.write("-----------------------\n");
            }
            System.out.println("Se ha generado el reporte de participantes en el archivo: " + archivoTXT);
        } catch (IOException e) {
            System.out.println("Ha ocurrido un ERROR al generar el reporte de participantes...\n** FINALIZANDO PROGRAMA **");
            e.printStackTrace();
        }
    }
}