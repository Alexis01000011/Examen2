package mx.com.ingsoft.adoo.examen.pruebas;

import mx.com.ingsoft.adoo.examen.entidades.Carrera;

public class TestCarrera {
    public static void main(String[] args) {
        for (String tmp: Carrera.obtenerNombreCarreras()) {
            System.out.println(tmp);
        }

    }
}
