package LeetCodeQuestions;

public class Q286 {
    public static void main(String[] args){
        int[] arr = {3,0,1};

        System.out.println(missingNumber(arr));
    }

    static int missingNumber(int[] nums) {
        // frist sort the array
        sort(nums);

        // after sorting find the missing element
        // in our case {4,0,2,1} after sorting {0,1,2,4}
        // at index 3 the element value is 4 so we found our answer that 3 is missing
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != i){
                return i;
            }
        }
        
        // another case will be like:
        // lets say our array is {0,1,2,3} and size of array is n = 5
        // if the code pointer is at last element of the index, which is 3 it means the above for loop didn't found the element
        // so definately it will the n or length of the array
        return nums.length;


    }


    static void sort(int[] arr){
        int i = 0;
        while(i < arr.length){

            // in the correctIndex no arr[i] - 1 will be there because we are starting from the 0
            int correctIndex = arr[i];

            if(arr[i] < arr.length && arr[i] != arr[correctIndex]){
                // swap
                swap(arr, i, correctIndex);
            } else{
                i++;
            }
        }
    }

    static void swap(int[] arr, int i1, int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
