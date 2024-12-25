package BitManipulationAndNumberSystem;

import java.util.Scanner;

public class OddOrEven {
    public static void main(String[] args){
        int n = 11;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter any number: ");
        n = sc.nextInt();

        if(isOdd(n)){
            System.out.println("N is odd !!");
        } else{
            System.out.println("N is Even !!");
        }
        sc.close();
    }

    static boolean isOdd(int n){
        return (n&1) == 1; // if 1 then it will return true and if 0 then it will return flase
    }
}
