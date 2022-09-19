public class LCM {
    public static void main(String[] args){
        int a = 9;
        int b = 18;

        System.out.println(lcm(a, b));
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

    static int lcm(int a, int b){
        /*
         * Formula for lcm:
         * multiplication of a and b  / HCF (Highest Common Factor) i.e gcd(a, b)
         */
        return a*b / gcd(a, b);
    }
}
