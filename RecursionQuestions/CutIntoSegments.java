// https://practice.geeksforgeeks.org/problems/cutted-segments1642/1

package RecursionQuestions;

public class CutIntoSegments {
    public static int maximizeCuts(int n, int x, int y, int z){
        // base conditions
        if(n == 0){
            return 0;
        }
        if(n < 0){
            return Integer.MIN_VALUE;
        }

//         int ans = 0;

        int xCall = maximizeCuts(n-x, x, y, z) + 1;
        int yCall = maximizeCuts(n-y, x, y, z) + 1;
        int zCall = maximizeCuts(n-z, x, y, z) + 1;

        return Math.max(xCall, Math.max(yCall, zCall));
    }
    public static void main(String[] args) {
        int rodLength = 7;
        int x=5, y=2, z=2;
        
        int ans = maximizeCuts(rodLength, x, y, z);

        /*
         * Conditions:
         * ans < 0 : invalid answer 
         * ans > 0 : valid answer
         * 
         * -- if invalid answer then make the ans 0
         */
        if(ans < 0){
            ans = 0;
        }
        System.out.println(ans);
    }
}
