import java.util.ArrayList;

public class PrintMatrixDiagonally {
    static ArrayList<Integer> downwardDiagonal(int N, int A[][])
    {
        // code here 
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[][] track = new boolean[N][N];
        
        for(int i = 0; i < N; i++){
            for(int j = i; j < N; j++){
                int row = i, col = j;
                    
                while(row < N && col >= 0){
                    if(!track[row][col]){
                        ans.add(A[row][col]);
                        track[row][col] = true;
                    }
                    row ++;
                    col --;
                }
            }
        }
        
        return ans;
    }

    public static void main(String[] args){
        int[][] matrix = {
            {1,2,3}, {4,5,6}, {7,8,9}
        };

        System.out.println(downwardDiagonal(matrix.length, matrix));
    }
}
