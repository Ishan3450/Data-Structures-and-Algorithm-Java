package RecursionQuestions.Backtracking;

/*
 ?  - DRAW A RECURSIVVE TREE TO UNDERSTAND IT PROPERLY and take the length of the string 4 to understand it properly
 * TC: O(N!)
 *  - let say a string size is n
 *  - at the very first level there will be n swaps
 *  - at next level n nodes will be there and n-1 swaps so n * n-1
 *  - at next level n*n-1 nodes will be terthere and n-2 swaps
 *  - occurs till 1 came
 * 
 *  - example: string abc of n=3
 *  - at first i=0 so loop will run for j=0,1,2 i.e 3 times so three function calls
 *  - at next i=1 so loop will run for j=1,2 i.e 2 i.e 3-1 but there are 3 nodes of previous calls so 3 * 2 = 6
 *  - at next 6 nodes and i=2 so loop will run for j=2 i.e 1 i.e 3-2 so 3 * 2 * 1 = 6
 *  - expression: n + (n*(n-1)) + (n*(n-1) * (n-2))  + (n*(n-1) * (n-2) * (n-3)) ..... (n*(n-1) * (n-2) * (n-3) .... * (1))
 *     - NOTE: just make an observation in the expression: the highest power is (n*(n-1) * (n-2) * (n-3) .... * (1)) the lst element, and the expression is similar to the factorial problem
 *     - so TC: O(N!)
 * 
 * SC: O(N) where n is the legnth of the string
 *  - as at first call i=0, then i=1, then i=2 then i=outOfBound so n+1 calls
 */

public class PermutationUsingBacktracking {
    public static void main(String[] args) {
        String s = "abc";

        permute(s.toCharArray(), 0);
    }

    public static void permute(char[] ch, int i) {
        // base condition
        if (i >= ch.length) {
            System.out.println(String.valueOf(ch));
            return;
        }

        // function body
        for (int j = i; j < ch.length; j++) {
            // recursive call
            swap(ch, i, j);
            // processing
            permute(ch, i + 1);
            // backtracking call
            swap(ch, i, j);
        }
    }

    public static void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
