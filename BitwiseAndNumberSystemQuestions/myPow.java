/*
 * Do a dry run on pen and paper, one will get the idea !!
 */
package BitwiseAndNumberSystemQuestions;

public class myPow {
    public static void main(String[] args) {
        double x = 5;
        int n = 2;

        System.out.println(myPowFunc(x, n));
    }

    // O(log n) solution
    static double myPowFunc(double x, int n) {
        // x: base
        // n: power

        double ans = 1;

        while (n > 0) {

            if ((n & 1) == 1) {
                ans *= x;
            }

            x *= x;
            n >>= 1;

            // * some logs to get you through the process :)
            // System.out.println("Ans: " + ans);
            // System.out.println("Base: " + x);
            // System.out.println("Power: " + n);
            // System.out.println();
        }

        return ans;
    }
}
