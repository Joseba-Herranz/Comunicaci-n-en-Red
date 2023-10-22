package ComunicacionRed_Ej1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serv {
	public static void main(String[] args) {
        ServerSocket servidor = null;
        
        try {
            servidor = new ServerSocket(7734);
            System.out.println("Servidor iniciado en el puerto 7734");
            
            
                Socket socket = servidor.accept();
                System.out.println("Cliente conectado desde " + socket.getInetAddress() + ":" + socket.getPort());

                InputStream entrada = socket.getInputStream();
                OutputStream salida = socket.getOutputStream();
                
           
                int numero = entrada.read();
                System.out.println("Número recibido: " + numero);
                
                if (numero == 200) {
                    System.out.println("Buenas y adios");
                    salida.write(200);
                }else {
                	System.out.println("Ese no era el numero esperado");
                }
                
                
                entrada.close();
                salida.close();
                socket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (servidor != null) {
                    servidor.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
