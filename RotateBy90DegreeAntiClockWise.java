public class RotateBy90DegreeAntiClockWise {
    static void rotate(int matrix[][]) 
    {
        int n = matrix.length;
        
        // step1: flip the matrix from right to left
        for(int i = 0; i<n; i++){
            reverseRow(matrix, i, n);
        }
        
        // step2: swap the [i,j] postion with [j,i] pos without being repeated indices
        for(int i=0; i<n; i++){
            for(int j = i; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
    static void reverseRow(int[][] matrix, int row, int n){
        int start = 0, end = n - 1;
        
        while(start < end){
            int temp = matrix[row][start];
            matrix[row][start] = matrix[row][end];
            matrix[row][end] = temp;
            
            start ++; end --;
        }
    }

    public static void main(String[] args){
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

        rotate(matrix);

        for(int arr[]: matrix){
            for(int elem: arr){
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}
