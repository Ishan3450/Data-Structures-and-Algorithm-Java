package RecursionQuestions;

public class CountInversions {
    public static void main(String[] args) {

    }
}

class BruteForceSolution {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    static long inversionCount(long arr[], long N) {
        // Your Code Here
        long count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}