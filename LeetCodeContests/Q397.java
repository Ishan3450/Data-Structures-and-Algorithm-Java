package LeetCodeContests;

public class Q397 {
    public static int integerReplacement(int n) {
        int count = 0;
        
        while(n != 1){
            if(n%2 == 0){
                n /= 2;
            } else{
                n -= 1;
            }
            count ++;
        }

        return count;
    }

    public static void main(String[] args){
        System.out.println(integerReplacement(4));
    }
}
