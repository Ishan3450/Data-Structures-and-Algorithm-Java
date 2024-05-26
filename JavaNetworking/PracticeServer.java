package JavaNetworking;

import java.io.*;
import java.net.*;

public class PracticeServer {
    public static void main(String[] args) throws IOException {
				ServerSocket server = new ServerSocket(8080);
			
				Socket listener = server.accept();
				
				// getting user input from client
				BufferedReader fromClient = new BufferedReader(new InputStreamReader(listener.getInputStream()));
				String s = fromClient.readLine();
				System.out.println("LOG: Got user data");
			
				int charsCount = 0;
				int digitsCount = 0;
			
				for(int i = 0 ; i < s.length() ; i ++) {
					char curr = s.charAt(i);
			
					if(Character.isDigit(curr)) digitsCount ++;
					if(Character.isAlphabetic(curr)) charsCount ++;
				}
			
				// sending response to client
				DataOutputStream toClient = new DataOutputStream(listener.getOutputStream());
				toClient.writeBytes("Total characters: " + charsCount + "\n");
				toClient.writeBytes("Total digits: " + digitsCount + "\n");
			
				System.out.println("LOG: Response Sent");
				System.out.println("LOG: Closing Socket");
				listener.close();
				server.close();
    }
}
