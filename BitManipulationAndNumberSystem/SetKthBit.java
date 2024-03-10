package BitManipulationAndNumberSystem;

public class SetKthBit {
    static int setKthBit(int N,int K){
        int mask = 1 << K;
        
        return N | mask;
    }
}

