/*
 * Problem statement: Place 1xM size tile in NxM size matrix
 */ 

package RecursionQuestions.Backtracking;

public class PlaceTiles {
    public static int place1xMTiles(int n, int m){
        // base condition
        /*
         * Now we also have two base condition
         * 
         * 1 is when n == m:
         * when n == m i.e 2 == 2 it means we have two ways to place the tile
         */
        if(n == m){
            return 2;
        }

        /*
         * 2 is when n < m;
         * when n < m i.e 2 < 4 it means height is 2 and we can't place the tile vertically so only 1 possibility
         */
        if(n < m){
            return 1;
        }

        // function body
        // we can place tiles in two ways:
        /*  
         * vertically
         * 
         * when matrix is of 3x2 and tile is of 1x2
         * and we place that tile vertical it means height of floor 3 - height of tile 2 -> 1 remaining
        */
        int vertical = place1xMTiles(n-m, m);

        /*
         * horizontally
         * 
         * when matrix is of 3x2 and tile will be 1x2
         * and if we place it horizontally it means width of floor 2 - width of tile 2 -> 0 so we have to move next row
         */
        int horizontally = place1xMTiles(n-1, m);

        return vertical + horizontally;
    }

    public static void main(String[] args){
        int n = 2, m = 4;
        System.out.println(place1xMTiles(n, m));
    }
}
