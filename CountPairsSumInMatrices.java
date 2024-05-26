public class CountPairsSumInMatrices {
    /*
        1st appraoch:
        
        1. brute force: simply traversing every element of mat1 and adding it wtih every element of mat2 and checking if sum == x having TC: O(N^4)
        2. More efficient: Simply store all the elements of mat1 then traverse mat2 and subtract each element of mat2 from x then check if that diff is present in set or not. TC: O(N^2) SC: O(N^2)
        3. Implemented using 2 pointers with constant space and TC: O(N^2)
    */
    
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        int r1 = 0, c1 = 0; // top left
        int r2 = n-1, c2 = n-1; // bottom right
        
        int count = 0;
        
        while(r1 < n && r2 >= 0){
            int sum = mat1[r1][c1] + mat2[r2][c2];
            
            if(sum == x){
                count ++;
                
                c1 ++;
                c2 --;
            } else if(sum < x){ // we have to maximize the sum to reach x
                c1 ++;
            } else { // sum > x then we have to minimize the sum to reach x
                c2 --;
            }
            
            // correcting pointers if they are out of bound
            if(c1 == n){
                r1 ++;
                c1 = 0;
            }
            
            if(c2 < 0){
                r2 --;
                c2 = n-1; // did mistake here: last time set it to 0
            }
        }
        
        return count;
    }
}
