package Arrays;

public class LinearSearch {
    public static void main(String[] args){
        int[] arr = {1,65,6,2,8,21};
        int target = 1;

        System.out.println(search(arr, target));
    }

    static int search(int[] arr, int target){
        return helper(arr, target, 0);
    }

    static int helper(int[] arr, int target, int index){
        // base condition
        if(index == arr.length - 1){
            return -1;
        }

        // recursive condition
        if(arr[index] == target){
            return index;
        } else{
            return helper(arr, target, ++index);
        }
    }


}
