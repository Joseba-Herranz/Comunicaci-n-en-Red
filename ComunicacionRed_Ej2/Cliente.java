package ComunicacionRed_Ej2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import ComunicacionRed_Ej2.Persona;

public class Cliente {
    public static void main(String[] args) {
        Socket cliente = null;
        ObjectOutputStream output = null;
        ObjectInputStream input = null;

        Persona nombre = new Persona("Jon", 35, null);
        
        try {
        	cliente = new Socket("localhost", 7735);
            System.out.println("Conectado al servidor en el puerto 7734");
            
            output = new ObjectOutputStream(cliente.getOutputStream());
            
            output.writeObject(nombre);
            
            input = new ObjectInputStream(cliente.getInputStream());
            Persona parent = (Persona) input.readObject();
            
            if (parent != null) {
                System.out.println("Nombre del padre: " + parent.getNombre());
                System.out.println("Edad del padre: " + parent.getEdad());
                System.out.println("Nombre de la madre: " + parent.getNombreMujer());
            } else {
                System.out.println("No tiene padres");
            }

            cliente.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (output != null) {
                    output.close();
                }
                if (cliente != null) {
                    cliente.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

