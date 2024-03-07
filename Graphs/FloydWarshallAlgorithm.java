package Graphs;

public class FloydWarshallAlgorithm {
    /*
     * To go from sourse -> destionation we will be using a helper node like:
     * --> weight(source -> helper) + weight(helper -> destination)
     * 
     * Reason for using helper node to travel:
     * - To find if there is more better way to travel to source using that helper
     * node
     * 
     * A normal initial matrix looks like: Diagonal cells are 0 rest are infinite
     */
    public void shortest_distance(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == -1) {
                    // * important to set this (did mistake last time solving this put
                    // Integer.MAX_VALUE last time and wrong ans was there)
                    matrix[i][j] = 10000; // value after reading constraints
                }
            }
        }

        for (int helper = 0; helper < matrix.length; helper++) {
            for (int source = 0; source < matrix.length; source++) {
                for (int destination = 0; destination < matrix.length; destination++) {
                    matrix[source][destination] = Math.min(matrix[source][destination],
                            matrix[source][helper] + matrix[helper][destination]);
                }
            }
        }
    }
}
