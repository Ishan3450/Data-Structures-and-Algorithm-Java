/*
 ! To know the working of the function just add a breakpint and start debugging at the starting of the function
 * Go, get a pen and a paper and do debugging and bit calculation parallely
 * XOR(^)
 * x    y   ans
 * 0    0    1
 * 0    1    0
 * 1    0    0
 * 1    1    1
 * 
 */

package BitManipulationAndNumberSystem;

public class ElementAppearingOnce {
    public static void main(String[] args){
        int[] arr = {2,3,3,4,2,6,4};

        System.out.println(giveAns(arr));
    }

    static int giveAns(int[] ans){
        int uniqueElement = 0;

        for(int n: ans){
            uniqueElement ^= n;
        }

        return uniqueElement;
    }
}
