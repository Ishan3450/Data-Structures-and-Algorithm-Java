/*
* SeiveOfEratosthenes
*  
* - We have to find the prime number till n.
* - So what we gonna do is like: 
* - We will go till the sqrt(n)
* - and we will eleminate all the factors of numbers 1 by 1
* - so at last only numbers will be there which are prime or we can say that they have no factors
* - we gonna take an Boolean array to do the task
* - COMPLEXITY: O(N * log(log N))
*/

public class SeiveOfEratosthenes {
    public static void main(String[] args){
        int n = 40;

        // ? NOTE:
        // * size of the array will be n+1 (1-based index)
        // * be default all the values of the array elements will be false
        // * we are gonna consider false as prime number and true as not prime numbers
        // * we are gonna consider element value as its index (1-based index)
        boolean[] primes = new boolean[n+1];

        seive(n, primes);

        for(int i=0; i<=n; i++){
            if(!primes[i]){
                System.out.println(i);
            }
        }

    }

    static void seive(int n, boolean[] primes){
        // going till sqrt(n)
        for(int i=2; i*i <= n; i++){
            if(!primes[i]){ // seeking for false value of the element

                // switching all the multiples of i to true
                for(int j=i*2; j<=n; j+=i){ // loop to check all the multiples of i
                    primes[j] = true;
                }
            }
        }

        // so now at this point we will have the primes array like false values will be there only for the prime numbers
    }


}
