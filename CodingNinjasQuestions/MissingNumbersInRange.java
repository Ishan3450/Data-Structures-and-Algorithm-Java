/*
 * https://www.codingninjas.com/codestudio/problems/missing-numbers_762938
 */

package CodingNinjasQuestions;

import java.util.ArrayList;
import java.util.List;

public class MissingNumbersInRange {
    public static void main(String[] args){
        int n = 3;
        int[] arr = {4,2,9};
        System.out.println(missingNumbers(arr, n));
    }

    public static List<Integer> missingNumbers(int[] arr, int n) {
        List<Integer> ans = new ArrayList<>();

        return helper(ans, arr, n, getMin(arr), getMax(arr));
    }

    static List<Integer> helper(List<Integer> list, int[] arr, int n, int i, int max){
        // base condition
        if(i == max){
            return list;
        }

        // function body

        if(isPresent(arr, i)){
            return helper(list, arr, n, i+1, max);
        } else{
            list.add(i);
            return helper(list, arr, n, i+1, max);
        }
    }

    static boolean isPresent(int[] arr, int target){
        for(int item: arr){
            if(item == target){
                return true;
            }
        }
        return false;
    }

    static int getMin(int[] arr){
        int min = arr[0];

        for(int item: arr){
            if(item < min){
                min = item;
            }
        }
        return min;
    }

    static int getMax(int[] arr){
        int max = arr[0];

        for(int item: arr){
            if(item > max){
                max = item;
            }
        }
        return max; 
    }

}
