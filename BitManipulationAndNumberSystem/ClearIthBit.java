package BitManipulationAndNumberSystem;

public class ClearIthBit {
    public static void main(String[] args) {
        int n = 10; // binary: 1010
        n = 8; // binary: 1000
        
        int i = 3; // 0 based index

        int mask = 1 << i;
        mask = ~mask;

        System.out.println(n & mask);
    }
}
