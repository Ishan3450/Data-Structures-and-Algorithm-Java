package JavaNetworking;

import java.io.*;
import java.net.*;

public class TCPServerWhichAdds2UserInputNumbers {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSoc = new ServerSocket(8080);
        
        while (true) {
            Socket listener = serverSoc.accept();

            BufferedReader userInput = new BufferedReader(new InputStreamReader(listener.getInputStream()));
            int num1 = Integer.parseInt(userInput.readLine());
            int num2 = Integer.parseInt(userInput.readLine());
            
            String sum = (num1 + num2) + "";

            System.out.println("Num1: " + num1 + ", Num2: " + num2 + ", Sum: " + sum);

            DataOutputStream userOutput = new DataOutputStream(listener.getOutputStream());
            userOutput.writeBytes("Sum: " + sum + "\n");
        }
    }
}
