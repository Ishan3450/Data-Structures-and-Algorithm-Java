package Recursion.Easy;

public class SumTillN {
    public static void main(String[] args){
        System.out.println(sum(5));
    }

    static int sum(int n){

        // base condition
        if(n <= 1){
            return 1;
        }

        // recursive condition
        return n + sum(n-1);
    }
}
