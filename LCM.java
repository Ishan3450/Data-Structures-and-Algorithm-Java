public class LCM {
    public static void main(String[] args){
        int a = 9;
        int b = 18;

        System.out.println(lcm(a, b));
    }

    static int gcd(int a, int b){
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

    static int lcm(int a, int b){
        /*
         * Formula for lcm:
         * multiplication of a and b  / HCF (Highest Common Factor) i.e gcd(a, b)
         */
        return a*b / gcd(a, b);
    }
}
