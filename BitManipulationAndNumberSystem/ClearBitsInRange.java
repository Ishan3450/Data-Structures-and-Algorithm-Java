package BitManipulationAndNumberSystem;

public class ClearBitsInRange {
    public static void main(String[] args) {
        int l = 1; // l from left
        int r = 2; // r from right

        int n = 15; // 1111

        int firstMask = (-1 << r+1); // part 1 // considering r as l
        int secondMask = (1 << l) - 1; // part 2 // considering l as r

        int finalMask = firstMask | secondMask;
        
        System.out.println(n & finalMask);


        // * PRINT THIS IF CONFUSED: 
        // System.out.println(Integer.toBinaryString(firstMask));
        // System.out.println(Integer.toBinaryString(secondMask));
        // System.out.println(Integer.toBinaryString(finalMask));
    }
}
