/*
 * 832. Flipping an Image
 * 
 * - First get the input of the function
 * - then on first basis reverse the array
 * - then invert the array
 */

package LeetCodeQuestions;


public class Q832 {
    public static void main(String[] args){
        int[][] image = {
            {1,1,0},
            {1,0,1},
            {0,0,0}
        };

        flipAndInvertImage(image);

        // just for crosscheck purpose
        for(int i=0; i<image.length;i++){
            for(int j=0; j<image[i].length; j++){
                System.out.print(image[i][j]);
            }
            System.out.println();
        }
    }

    static int[][] flipAndInvertImage(int[][] image) {

        for(int[] row: image){
            int start = 0;
            int end = row.length - 1;

            while(start <= end){
                // swap
                int temp = row[start] ^ 1;
                row[start] = row[end] ^ 1;
                row[end] = temp;

                start ++;
                end --;
            }
        }
        return image;
    }
}
