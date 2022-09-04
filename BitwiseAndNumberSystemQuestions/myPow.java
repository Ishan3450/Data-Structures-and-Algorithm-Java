package BitwiseAndNumberSystemQuestions;

public class myPow {
    public static void main(String[] args){
        double x = 2;
        int n = 10;

        System.out.println(myPow(x, n));
    }

    // O(log n) solution
    static double myPow(double x, int n) {
        // x: base
        // n: power

        double ans = 1;

        while(n > 0){

            // some logs to get you through the process :)
            System.out.println("Ans: " + ans);
            System.out.println("x: " + x);
            System.out.println("n: " + n);
            System.out.println();
            
            
            if((n & 1) == 1){
                ans *= x;
            }

            x *= x;
            n >>= 1;
        }

        return ans;
    }
}
