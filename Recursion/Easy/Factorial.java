package Recursion.Easy;

public class Factorial {
    public static void main(String[] args){
        System.out.println(factorial(5));
    }

    static int factorial(int n){
        
        // base condition
        if(n <= 1){
            return 1;
        }

        // recursive condition
        return n * factorial(n-1);
    }
}
