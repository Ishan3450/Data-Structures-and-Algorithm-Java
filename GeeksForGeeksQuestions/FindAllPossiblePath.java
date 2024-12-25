/*
 ! Not Completely Solved
 */

import java.util.ArrayList;

public class FindAllPossiblePath {
    public static void main(String[] args){

        int[][] field = {
            {1,2,3},
            {4,5,6}
        };

        ArrayList<Integer> list = new ArrayList<>();

        System.out.println(helper(list, 0, 0, 2, 3, field));

    }

    // public static ArrayList<ArrayList<Integer>> findAllPossiblePaths(int n,int m, int[][] grid) {
    //     // code here
    // }

    static ArrayList<ArrayList<Integer>> helper(ArrayList<Integer> paths, int row, int col, int n, int m, int[][] grid){
        // base condition
        if(row == n-1 && col == m-1){
            paths.add(grid[row][col]);
            System.out.println(paths);

            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ans.add(paths);

            paths.clear();

            return ans;
        }

        // function body
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        if(row < n-1){
            paths.add(grid[row][col]);
            list.addAll(helper(paths, row+1, col, n, m, grid));
        }

        if(col < m-1){
            paths.add(grid[row][col]);
            list.addAll(helper(paths, row, col+1, n, m, grid));
        }

        return list;
    }

}
