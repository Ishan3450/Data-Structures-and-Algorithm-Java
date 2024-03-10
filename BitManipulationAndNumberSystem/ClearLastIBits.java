package BitManipulationAndNumberSystem;

public class ClearLastIBits {
    public static void main(String[] args) {
        int n = 10; // 1010
        int i = 2;

        int mask = -1 << i; // special mask
        // * Binary of -1 is 11111111111111111111111111111111
        // * PRINT THIS STATEMENT IF CONFUSED IN MASK: System.out.println(Integer.toBinaryString(mask));

        System.out.println(n & mask);
    }
}
