/*
 ? To get prime of any number there are just few intuations:
 * - Loop will go till the sqrt(n).
 * - Like, for 36 we will go till 6 and we will get the answer.
 * - Complexity: O(sqrt(n))
 * - We are going till the sqrt(n) because after that all the answers will be repeting
 */

public class PrimeNumbers {
    public static void main(String[] args){
        int n = 3;

        System.out.println(isPrime(n));
    }

    static boolean isPrime(int n){
        // edge case
        if(n<=1){
            return false;
        }

        int c = 2;

        // running loop till the sqrt(n)
        while(c * c <= n){
            if(n%c == 0){
                return false;
            }

            c++;
        }

        return true;
    }
}
