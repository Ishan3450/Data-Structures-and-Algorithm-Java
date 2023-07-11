/*

   sc      ec
sr 1  2  3  4
   5  6  7  8
   9 10 11 12
er 13 14 15 16

Steps: 
print first row
print last column
print last row in rev order
print first col in rev order

1st row -> sr[sc -> ec] && sr++
last col -> ec[sr -> er] && ec--
last row in rev -> er[ec -> sc] && er--
1st col -> sc[er -> sr] && sc++

*/

class KthElementInSpiralMatrix
{
    int findK(int A[][], int n, int m, int k)
    {
        // starting row and ending row variables
	    int sr, er;
	   // starting column and ending column variable
	    int sc, ec;
	    
	    // initialization
	    sr = sc = 0;
	    er = n-1;
	    ec = m-1;
	    
	    int count = 0; // count variable to keep track which element we are on 
	    int kthElement = 0;
	    
        while(count < n*m){
            // Step 1: Print first row
    	   for(int i=sc; count < n*m && i <= ec; i++){
    	       if(++count == k){
    	           kthElement = A[sr][i];
    	           return kthElement;
    	       }
    	   }
    	   sr++;
    	   
    	   // Step 2: Print last column
    	   for(int i=sr; count < n*m && i <= er; i++){
    	       if(++count == k){
    	           kthElement = A[i][ec];
    	           return kthElement;
    	       }
    	   }
    	   ec--;
    	   
    	   // Step 3: Print last row in reverse order
    	   for(int i=ec; count < n*m && i >= sc; i--){
    	       if(++count == k){
    	           kthElement = A[er][i];
    	           return kthElement;
    	       }
    	   }
    	   er--;
    
    
    	   // Step 4: Print first column in reverse order
    	   for(int i=er; count < n*m && i >= sr; i--){
    	       if(++count == k){
    	           kthElement = A[i][sc];
    	           return kthElement;
    	       }
    	   }
    	   sc++;
        }
        return kthElement;
    }
}