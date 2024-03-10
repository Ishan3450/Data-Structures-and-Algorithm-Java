package Recursion.Easy;

public class ProductOfDigits {
    public static void main(String[] args){
        int a = 1234;

        System.out.println(productOfDigits(a));
    }

    static int productOfDigits(int n){
        // base condition
        if(n == 0){
            return 1;
        }

        // function body
        int last = n % 10;
        n /= 10;

        // recursive condition
        return last * productOfDigits(n);
    }
}
