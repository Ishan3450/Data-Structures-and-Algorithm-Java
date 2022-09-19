public class GCD {
    public static void main(String[] args){
        int a = 4;
        int b = 9;
        System.out.println(gcd(a, b));
    }

    static int gcd(int a, int b){
        /*
         * Formula of GCD using Euclidian Algorithm:
         * gcd(remainder(b,a), a);
         */

         // base condition
         if(a == 0){ // if a is 0 the the gcd is b
            return b;
         }

         //recursive condition
         return gcd(b%a, a);
    }
}
