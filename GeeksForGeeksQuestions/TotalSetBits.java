// * SOLVED USING RECURSION

package GeeksForGeeksQuestions;

public class TotalSetBits {
    public static void main(String[] args){
        int n = 17;

        System.out.println(countSetBits(n));
    }
    
    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n){
        // Your code here
        return recursiveSetCounts(n, 0);
        
    }

    public static int recursiveSetCounts(int n, int count){

        // base condition
        if(n==0){
            return count;
        }
        
        // body
        count += getSetBitsCount(n);
        
        // recursive condition
        return recursiveSetCounts(n-1, count);
    }
    
    static int getSetBitsCount(int n){
        int counter = 0;
        
        while(n > 0){
            if((n&1) == 1){
                counter ++;
            }
            
            n >>= 1;
        }
        
        return counter;
    }
}
