import java.io.*;
import java.net.*;

//primero correr Servidor_Chat y luego Cliente_Chat

public class Servidor_Chat {

    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(4242);
            Socket socket = servidor.accept();
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            String enviar = "", recibido = "";
            enviar = "Bienvenido";
            dout.writeUTF(enviar);
            dout.flush();
            while (recibido.equals("salir") == false) {
                recibido = din.readUTF();
                System.out.println("Cliente dice: " + recibido);
                enviar = buffer.readLine();
                dout.writeUTF(enviar);
                dout.flush();
            }
            din.close();
            dout.close();
            socket.close();
            servidor.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
