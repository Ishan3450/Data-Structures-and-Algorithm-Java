import java.util.ArrayList;

public class Factors {
    public static void main(String[] args){
        int n = 36;

        System.out.println("Factors of " + n + " : " + countFactors(n));

        System.out.print("Factors Element of " + n + " : ");
        countFactorsElements(20);
    }

    /*
     * There are multiple approaches to get the factors:
     * - O(n) : run loop till n
     * - O(n/2) : run loop till n/2
     * - but in this file we are going to do the O(sqrt(n)) solution which is the most optimize solution.
     */

    // O(sqrt(n)) solution
    static int countFactors(int N) {
        // edge case
        if(N == 0){
            return 0;
        }

        /*
         * - count += 2 is there it means:
         * - as we are goint till sqrt(n) we have less checks
         * - so if 2 * 3 is 6 does it not mean that 3 * 2 is also 6, like that
         * - so we are adding the factors count by 2
         * - suppose we have to find factors of 36
         * - so there will be 6*6=36 so to prevent that another condition block is there
         * - debug it or use pen and paper to run and then you will get your doubts clear
         */

        int count = 0;
        for(int i=1; i*i <= N; i++){
            if(N%i == 0){
                if(N/i == i){ // checking for 6*6=36 like case as I mentioned above
                    count ++;
                } else{
                    count += 2;
                }
            }
        }
        return count;
    }

    // * same function as above but the difference is in this function we are printing the element
    // O(sqrt(n)) solution
    static void countFactorsElements(int N) {
        // edge case
        if(N == 0){
            System.out.println(0);
            return ;
        }
    
        ArrayList<Integer> elements = new ArrayList<>();
        for(int i=1; i*i <= N; i++){
            if(N%i == 0){
                if(N/i == i){ // checking for 6*6=36 like case
                    System.out.print(i + " ");
                } else{
                    System.out.print(i + " ");
                    elements.add(N/i);
                }
            }
        }

        // printing the arraylist elements so all the factors are printed in the ascending order
        for(int i=elements.size() - 1; i>=1; i--){
            System.out.print(elements.get(i) + " ");
        }

    }
}
