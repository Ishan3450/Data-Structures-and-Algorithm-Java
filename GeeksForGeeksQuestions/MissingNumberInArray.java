/*
 * Missing number in array
 * https://practice.geeksforgeeks.org/problems/missing-number-in-array1416/1?page=1&difficulty[]=-2&difficulty[]=-1&difficulty[]=0&category[]=Arrays&sortBy=submissions
 * 
 * - Very easy question
 * - basically there is given an array and the original length of array
 * - we have to find the missing number of the array
 * - function will take arr and n
 * - first take the min and max value 
 * - then do sum of from min value to n and store it in originalSum
 * - then do sum of array values from 0 to n-1 and store it in arrayValueSum 
 * - then just return the difference between originalSum - arrayValueSum and boom we got our 307 test cases passes.
 */


public class MissingNumberInArray {
    public static void main(String[] args){
        int[] A = {2};
        int n = 2;
        System.out.println(MissingNumber(A, n));
        
    }

    static int MissingNumber(int array[], int n) {
        int min = 1;
        
        int originalSum = 0;
        int givenArraySum = 0;
        // first getting sum of all the 1 to n numbers
        for(int i=min; i<=n; i++){
            originalSum += i;
        }
        
        // now getting the sum of the given array
        for(int i=0; i<n-1; i++){
            givenArraySum += array[i];
        }
        
        // returning the difference of the originalSum and givenArraySum
        return originalSum - givenArraySum;
     }
}
