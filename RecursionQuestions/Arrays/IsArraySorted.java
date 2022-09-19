package RecursionQuestions.Arrays;

public class IsArraySorted {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};

        System.out.println(isSorted(arr));
    }

    static boolean isSorted(int[] arr){
        int initialIndex = 0;
        return helper(arr, initialIndex);
    }

    static boolean helper(int[] arr, int index){
        // base condition
        if(index == arr.length - 1){
            return true;
        }

        // recursive condition
        return arr[index] < arr[index+1] && helper(arr, ++index);
    }
}
