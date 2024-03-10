package BitManipulationAndNumberSystem;

public class CheckKthBitIsSetOrNot {
    static boolean checkKthBit(int n, int k) {
        int mask = 1 << k;
        int ans = n & mask;

        return ans != 0;
    }
}
