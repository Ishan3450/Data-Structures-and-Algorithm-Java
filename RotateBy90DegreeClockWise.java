/*
 * LeetCode 48
 * Approach:
    * Step1: flip the matrix upside down
    * Step2: swap the i,j with j,i without being repetated 
 */
public class RotateBy90DegreeClockWise {
    public static void rotate(int[][] matrix) {
        
        // flipping the matrix upside down
        int start = 0, end = matrix.length-1;
        while(start < end){
            for(int i=0; i<matrix[0].length; i++){
                // swap
                int temp = matrix[start][i];
                matrix[start][i] = matrix[end][i];
                matrix[end][i] = temp;
            }
            start ++;
            end --;
        }

        // ***** IMP LOOP to understand the logic
        for(int i=0; i<matrix.length; i++){
            for(int j=i /* Mark here j = i to we are traversing for the upper triangle only */; j<matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
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
