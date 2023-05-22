package mx.com.ingsoft.adoo.examen.entidades;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Participante {
    private static String matricula;
    private static String nombre;
    private String aPaterno;
    private String aMaterno;
    private String email;
    private Carrera carrera;
    private String generacion;
    private String institucion;
    private boolean activo;

    public static String getMatricula() {
        return matricula;
    }

    public static void setMatricula(String matricula) {
        Participante.matricula = matricula;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        Participante.nombre = nombre;
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

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public String getGeneracion() {
        return generacion;
    }

    public void setGeneracion(String generacion) {
        this.generacion = generacion;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public static void enviaDatosRegistro(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese su matricula: ");
        String matricula = sc.nextLine();

        System.out.print("Ingrese su nombre (solo nombre): ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese su apellido paterno: ");
        String aPaterno = sc.nextLine();

        System.out.print("Ingrese su apellido materno (opcional): ");
        String aMaterno = sc.nextLine();

        System.out.print("Ingrese su email: ");
        String email = sc.nextLine();

        System.out.print("Las carreras son las siguientes:\n");
        for (String tmp: Carrera.obtenerNombreCarreras()) {
            System.out.println(tmp);
        }
        int clave = sc.nextInt();
        sc.nextLine();
        String carrera = obtenerCarrera(clave);

        System.out.print("Ingrese su generación: ");
        String generacion = sc.nextLine();

        System.out.print("Ingrese la institución en la que labora: ");
        String institucion = sc.nextLine();

        System.out.print("¿Esta activo? (Y | N) ");
        String activo = sc.nextLine();

        String archivoCSV = "participantes.csv";

        try (FileWriter writer = new FileWriter(archivoCSV, true)) {
            writer.append(matricula)
                    .append(",")
                    .append(nombre)
                    .append(",")
                    .append(aPaterno)
                    .append(",")
                    .append(aMaterno)
                    .append(",")
                    .append(email)
                    .append(",")
                    .append(carrera)
                    .append(",")
                    .append(generacion)
                    .append(",")
                    .append(institucion)
                    .append(",")
                    .append(activo)
                    .append("\n");

            recibeConfirmacionEmail();
        } catch (IOException e) {
            Administrador.confirmacionFallida();
            e.printStackTrace();
        }
        sc.close();
    }

    public static void recibeConfirmacionEmail(){
        Administrador.enviaConfirmacionEmail();
    }

    private static String obtenerCarrera(int claveCarrera) {
        String[] carreras = Carrera.obtenerNombreCarreras();

        if (claveCarrera >= 1 && claveCarrera <= carreras.length) {
            return carreras[claveCarrera - 1];
        }
        return "";
    }
}