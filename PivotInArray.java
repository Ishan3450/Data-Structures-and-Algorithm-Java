public class PivotInArray {
    static int getPivot(int[] arr){
        int start= 0;
        int end = arr.length - 1;


        while(start <= end){
            int mid = start + (end - start) / 2;

            // case 1
            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }

            // case 2
            if(mid > start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }

            // case 3
            if(arr[start] > arr[mid]){
                end = mid - 1;
            } else{
                start = mid + 1;
            }

        }

        return -1;
    }

    public static void main(String[] args){
        int[] arr = {5,6,7,8,9,1,2};

        System.out.println(getPivot(arr));
    }
}
