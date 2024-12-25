class SetMatrixZeroes {
    public void setMatrixZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        boolean c0 = false;
        
        for(int i = 0 ; i < n ; i ++) {
            for(int j = 0 ; j < m ; j ++) {
                if(mat[i][j] == 0) {
                    
                    // marking row
                    mat[i][0] = 0; 
                    
                    // marking col
                    if(j == 0) {
                        c0 = true;
                    } else {
                        mat[0][j] = 0;
                    }
                }
            }
        }
        
        // (1,1) -> (n-1, m-1) because we have marked the top elements 0 wherever we encounted zero in the first traversal
        for(int i = 1; i < n ; i ++) {
            for(int j = 1 ; j < m ; j ++) {
                if(mat[0][j] == 0 || mat[i][0] == 0) {
                    mat[i][j] = 0;
                }
            }
        }
        
        // mark 0th row 
        if(mat[0][0] == 0) {
            for(int c = 0 ; c < m ; c ++) {
                mat[0][c] = 0;
            }
        }
        
        // mark 
        if(c0) {
            for(int r = 0 ; r < n ; r ++) {
                mat[r][0] = 0;
            }
        }
    }
}