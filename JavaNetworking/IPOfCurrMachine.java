package JavaNetworking;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPOfCurrMachine {
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println(ip.getHostAddress());
            System.out.println(ip.getHostName());
        } catch (UnknownHostException e) {
        }
    }
}
