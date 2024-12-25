package BitManipulationAndNumberSystem;

public class UpdateIthBit {
    private static int clearIthBit(int n, int i){
        int mask = 1 << i;
        mask = ~mask;
        return (n & mask);
    }

    public static void updateIthBit(int n, int i, int target){
        n = clearIthBit(n, i);
        int mask = target << i; // mask bit depends on target
        System.out.println(n | mask);
    }

    public static void main(String[] args) {
        int n = 10; // 1010
        int i = 2;
        int target = 1;

        updateIthBit(n, i, target);
    }

}
