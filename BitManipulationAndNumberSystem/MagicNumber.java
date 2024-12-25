package BitManipulationAndNumberSystem;

import java.lang.Math;

public class MagicNumber {
    public static void main(String[] args){
        int num = 6;

        System.out.println("Approach 1: " + getMagicNumber(num));
        System.out.println("Approach 2: " + getMagicNumber2(num));
    }

    // 2nd approach
    static int getMagicNumber2(int num){
        int ans = 0;

        int i = 1;
        int base = 5;

        while(num > 0){
            int last = num & 1; // last digit
            num >>= 1; // right shifting num by 1

            ans += (Math.pow(base, i) * last);
            // System.out.println("Answer after " + i + " iteration: " + ans);
            i++;
        }

        return ans;
    }

    static int getMagicNumber(int num){
        int ans = 0;
        int base = 5;

        while(num > 0){
            int last = num & 1; // last digit of any binary number using & 1
            num >>= 1; // right shifting the number by 1

            ans += last * base; // adding the last digit with the product of base in ans

            base *= 5; // multiplying base by 5 every time loop executes
        }

        // returning the answer
        return ans;
    }
}
