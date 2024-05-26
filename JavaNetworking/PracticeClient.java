package JavaNetworking;

import java.io.*;
import java.net.*;

public class PracticeClient {
    public static void main(String[] args) throws IOException {
				Socket client = new Socket("localhost", 8080);
				
				// getting user input and seding it to the server
				System.out.print("Enter any word: ");
				BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
				
				DataOutputStream toServer = new DataOutputStream(client.getOutputStream());
				toServer.writeBytes(userInput.readLine() + "\n");
				System.out.println("Sent to server");
			
				// getting response from the server
				BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
				System.out.println("Response from server: ");
				System.out.println(fromServer.readLine());
				System.out.println(fromServer.readLine());
			
				client.close();
    }
}
