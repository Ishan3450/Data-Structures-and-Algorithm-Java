package BitManipulationAndNumberSystem;

public class CountSetBits {
    public static void main(String[] args) {
        method1(15);
        method2(15);
    }

    // TC: O(log n)
    public static void method1(int n){
        int count = 0;

        while(n > 0){
            if((n & 1) == 1) count ++;
            n >>= 1;
        }

        System.out.println(count);
    }

    /*
     * Slight unintuitive but faster than method 1
     */
    public static void method2(int n) {
        int count = 0;

        while(n > 0){
            count ++;
            n = n & (n-1);
        }

        System.out.println(count);
    }
}

