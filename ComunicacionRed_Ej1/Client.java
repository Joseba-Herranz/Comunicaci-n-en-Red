package ComunicacionRed_Ej1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		
		Socket socket = null;
		OutputStream output = null;
		int numero = 200;
        
        try {
            socket = new Socket("localhost", 7734);
            System.out.println("Conectado al servidor en el puerto 7734");
            
            output = socket.getOutputStream();
            output.write(numero);
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}