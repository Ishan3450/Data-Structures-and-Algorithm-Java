package BitwiseAndNumberSystemQuestions;

public class TotalNumberOfSetBits {
    public static void main(String[] args) {
        int n = 26;

        System.out.println("Binary: " + Integer.toBinaryString(n));
        System.out.println("Approach 1: " + getSetBits(n));
        System.out.println("Approach Easy: " + getSetBits2(n));
    }

    // * easy approach
    static int getSetBits2(int n){
        int counter = 0;

        while(n > 0){
            counter ++;
            n = n & (n-1);
        }

        return counter; // number of iteration will be our answer
    }


    static int getSetBits(int n) {
        int ans = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                ans++;
            }

            n >>= 1;
        }
        return ans;
    }
}
