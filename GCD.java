public class GCD {
    public static void main(String[] args){
        int a = 4;
        int b = 9;
        System.out.println(gcd(a, b));
    }

    // recommended and easy one
    static int gcd2(int a, int b){
        // base conditions
        if(a == 0){
            return b;
        } else if(b == 0){
            return a;
        }

        // function body
        if(a >= b){
            return gcd2(a-b,b);
        } else{
            return gcd2(b-a, b);
        }
    }

    // slightly less recommended as % operation is a somewhat more time taking operation
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
