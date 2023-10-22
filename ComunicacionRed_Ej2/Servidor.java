package ComunicacionRed_Ej2;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	 public static void main(String[] args) throws IOException, ClassNotFoundException {
	        ServerSocket serverSocket = new ServerSocket(7735);
	        System.out.println("Iniciado");

	        while (true) {
	            Socket socket = serverSocket.accept();
	            System.out.println("Cliente conectado");

	            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
	            Persona person = (Persona) objectInputStream.readObject();

	            if (person.getNombre().equals("Juan")) {
	                Persona parent = new Persona("Rariano Majoy", 40, "Fervira Elnandez");
	                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
	                objectOutputStream.writeObject(parent);
	            } else {
	                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
	                objectOutputStream.writeObject(null);
	            }

	            socket.close();
	            serverSocket.close();
	        }
	    }
	}