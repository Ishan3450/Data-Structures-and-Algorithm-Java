package JavaNetworking;

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        Socket clientSocket = new Socket("localhost", 8080);

        System.out.println("Enter num1: ");
        BufferedReader num1 = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter num2: ");
        BufferedReader num2 = new BufferedReader(new InputStreamReader(System.in));

        DataOutputStream dataOut = new DataOutputStream(clientSocket.getOutputStream());
        String n1 = num1.readLine();
        String n2 = num2.readLine();
        dataOut.writeBytes(n1 + "\n"); // dataOut goes to server
        dataOut.writeBytes(n2 + "\n"); // dataOut goes to server

        BufferedReader serverOutput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String s2 = serverOutput.readLine();
        System.out.println("From server: " + s2);

        clientSocket.close();
    }    
}
