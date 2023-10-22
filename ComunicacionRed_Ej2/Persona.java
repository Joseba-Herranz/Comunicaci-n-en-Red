package ComunicacionRed_Ej2;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private int edad;
    private String nombreMujer;

    public Persona(String nombre, int edad, String nombreMujer) {
        this.nombre = nombre;
        this.edad = edad;
        this.nombreMujer = nombreMujer;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombreMujer() {
        return nombreMujer;
    }

    public void setNombreMujer(String nombreMujer) {
        this.nombreMujer = nombreMujer;
    }
}

