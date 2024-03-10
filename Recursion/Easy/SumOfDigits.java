package Recursion.Easy;

public class SumOfDigits {
    public static void main(String[] args){
        int n = 12345;
        System.out.println(sumOfDigits_NormalWay(n));
        System.out.println(sumOfDigits_RecursiveWay(n));
    }

    static int sumOfDigits_NormalWay(int n){
        int sum = 0;

        while(n > 0){
            int last = n % 10;
            sum += last;
            n = n / 10;
        }

        return sum;
    }

    /*
     * formula : last digit + sumOfDigits(rest of number)
     * for : 123
     * 1 : 1 + sum(23)
     * 2 : 2 + sum(3)
     * 3 : 3 + sum(0) - base condition
     */
    static int sumOfDigits_RecursiveWay(int n){
        // base condition
        if(n == 0){
            return 0;
        }

        // function body
        int last = n % 10;
        n /= 10;
        
        // recursive condition
        return last + sumOfDigits_RecursiveWay(n);
        // or
        // ? SHORTHAND Formula
        // * return (n%10) + sumOfDigits_RecursiveWay(n/10); 
    }
}
