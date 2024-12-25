public class SquareRootOfNum {
    public static void main(String[] args){
        int n = 5;

        System.out.println(getSqrt(n));
        System.out.println(getSqrtWithPrecision(n, 2));

    }

    static int getSqrt(int n){
        int start = 2;
        int end = n - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            int midSqr = mid * mid;

            if(midSqr == n){
                return mid;
            } else if(midSqr > n){
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }

        // if no any root found then returning the floor of the number n
        return end;
    }

    static double getSqrtWithPrecision(int n, int precision){
        int start = 2;
        int end = n - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            int midSqr = mid * mid;

            if(midSqr == n){
                return mid;
            } else if(midSqr > n){
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }

        // Precision part starts here
        double root = 0.0;
        double increment = 0.1;

        for(int i=0; i<precision; i++){
            while(root * root <= n){
                root += increment;
            }

            root -= increment; // to get the last correct one for 2.2 the loop violates at 2.3 so by decrement 0.1 we get the 2.2
            increment /= 10; // this will runn for 2nd presicion point
        }

        return root;
    }
}
