package mx.com.ingsoft.adoo.examen.entidades;

public class Carrera {
    private String claveCarrera;
    private static String[] nombreCarreras = {
            "1. Ingeniería en Computación",
            "2. Ingeniería de Software",
            "3. Ingeniería Eléctrica",
            "4. Ingeniería en Electrónica Industrial",
            "5. Ingeniería en Diseño Industrial",
            "6. Ingeniería en Robótica y Mecatrónica"
    };

    public String getClaveCarrera() {
        return claveCarrera;
    }

    public void setClaveCarrera(String claveCarrera) {
        this.claveCarrera = claveCarrera;
    }

    public static String[] obtenerNombreCarreras() {
        return nombreCarreras;
    }
}