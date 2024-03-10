package BinarySearch;

// Reference from 1:00:00 --> https://learn.thecodehelp.in/s/courses/63ac9183e4b0f1067f1b7b32/take

/*
    Observations:

    on the left side of the answer-> the {even, odd} makes a pair
    and on the right side of the answer -> the {odd, even} makes a pair
    NOTE: even and odd are the indices of the array
*/
public class OneOddOccurringElementInArray{
	public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,4,3,500,500,4,4};
        // int[] arr = {1,1,2,2,3,3,4,4,5};

        int start = 0, end = arr.length - 1;

        while(start < end){

            /*
                * Optional Condition if using then change the while condition to start <= end.

                if(start == end){
                    System.out.println("Hello world! " + arr[end]);
                    return;
                }            
            */

            int mid = start + (end - start) / 2;

            System.out.println(start + " " + mid + " " + end);

            if((mid&1) == 0){
                if(arr[mid] == arr[mid+1]){ // standing at the left
                    start = mid + 2;
                } else{ // standing at the right
                    end = mid; // potential answer
                }
            } else{
                if(arr[mid] == arr[mid-1]){ // standing at the left
                    start = mid + 1;
                } else{ // standing at the right
                    end = mid - 1;
                }
            }
        }

        System.out.println("Hello world! " + arr[end]);
    }	
}