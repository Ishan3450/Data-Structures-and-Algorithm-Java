package JavaNetworking;

import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);

        while(true){
            Socket listener = serverSocket.accept();

            BufferedReader clientInput = new BufferedReader(new InputStreamReader(listener.getInputStream()));
            DataOutputStream clientAck = new DataOutputStream(listener.getOutputStream());

            String s = clientInput.readLine();
            String ack = s + " :: Received";

            System.out.println("Client: " + s);
            clientAck.writeBytes(ack + "\n");
        }
        
    }
}
