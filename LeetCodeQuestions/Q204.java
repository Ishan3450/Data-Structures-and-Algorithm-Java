/*
*  204. Count Primes
*
* This Approach is also known as : SeiveOfEratosthenes
* 
* - We have to find the prime number till n-1.
* - So what we gonna do is like: 
* - We will go till the sqrt(n)
* - and we will eleminate all the factors of numbers of the loop till sqrt(n) one by one
* - so at last only numbers will be there which are prime or we can say that they have no factors
* - we gonna take an Boolean array to do the task
*/

package LeetCodeQuestions;

public class Q204 {
    public static void main(String[] args){
        int n = 40;

        System.out.println(countPrimes(n));

    }

    static int countPrimes(int n) {
        // ? NOTE:
        /* 
         * size of the array will be n+1 (1-based index)
         * be default all the values of the array elements will be false
         * we are gonna consider false as prime number and true as not prime numbers
         * we are gonna consider index as its element value (1-based index)   
        */
        boolean[] primes = new boolean[n+1];
        
        seive(n, primes);
        int count = 0;
        
        for(int i=2; i<n; i++){
            if(!primes[i]){
                count ++;
            }
        }
        
        return count;
    }
    
    static void seive(int n, boolean[] primes){
        for(int i=2; i*i < n; i++){
            if(!primes[i]){ // seeking for false value of the element

                // switching all the multiples of i to true
                for(int j=i*2; j<n; j+=i){
                    primes[j] = true;
                }
            }
        }
        // so now at this point we will have the primes array like false values will be there only for the prime numbers
    }
}
