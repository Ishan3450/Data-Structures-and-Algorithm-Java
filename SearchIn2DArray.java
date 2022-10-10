public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                { 12, 32, 24, 42 },
                { 54, 65 },
                { 87, 45, 83, 34, 57, 643 },
                { 123, 345, 321235, 31254 }
        };
        int target = 87;

        // System.out.println("Using basic search");
        // System.out.println("-----------------------------------------------------");
        // boolean isFound = search(arr, target);

        // if (isFound) {
        //     System.out.println("Yay !! Element found in the arrray !!");
        // } else {
        //     System.out.println("Oops !! Element not found in the array !!");
        // }

        System.out.println("Using optimized search");
        System.out.println("-----------------------------------------------------");
        boolean isFoundOptimized = search_optimized(arr, target);

        if (isFoundOptimized) {
            System.out.println("Yay !! Element found in the arrray !!");
        } else {
            System.out.println("Oops !! Element not found in the array !!");
        }
    }

    static boolean search(int[][] arr, int target) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == target) {
                    return true;
                }
            }
            System.out.println();
        }
        return false;
    }

    // search_optimized is the more optimized function for searching rather than the search function written upwards
    // * just use row_count first then use the col_count like arr[row][col]i made a mistake my bad :)
    static boolean search_optimized(int[][] arr, int target) {
        int r = 0;
        int c = 0;
        while (r < arr.length) {
            // System.out.println("Printing element array of [" + r + "][" + row_count + "]");

            if (arr[r][c] == target) {
                return true;
            } else if (c == arr[r].length - 1) {
                // System.out.println("Column count incremented");
                r++;
                c = 0;
            } else if (c < arr[r].length) {
                // System.out.println("Row count incremented");
                c++;
            }
        }

        return false;
    }
}
