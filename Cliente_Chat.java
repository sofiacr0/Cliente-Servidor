import java.io.*;
import java.net.*;

//primero correr Servidor_Chat y luego Cliente_Chat

public class Cliente_Chat {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 4242);
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            String enviar = "", recibido = "";

            recibido = din.readUTF();
            System.out.println("Servidor dice: " + recibido);

            while (enviar.equals("salir") == false) {
                enviar = buffer.readLine();
                dout.writeUTF(enviar);
                dout.flush();
                recibido = din.readUTF();
                System.out.println("Servidor dice: " + recibido);
            }
            din.close();
            dout.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
