package Queues;

public class CircularTour {

    // leet code
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start, shortage, balance;
        start = shortage = balance = 0;

        for(int i=0; i<gas.length; i++){
            balance += gas[i] - cost[i];

            if(balance < 0){
                shortage += balance;
                start = i+1;
                balance = 0;
            }
        }

        if(shortage + balance >= 0){
            return start;
        }
        return -1;
    }
    
    // GFG
    int tour(int petrol[], int distance[]){
	    // Your code here
	    int start = 0;
	    int shortage = 0;
	    int balance = 0;
	    
	    for(int i=0; i<petrol.length; i++){
	        balance += petrol[i] - distance[i];
	        
	        if(balance < 0){ // if negative 
	            shortage += balance;
	            balance = 0;
	            start = i+1;
	        }
	    }
	    
	    if(balance + shortage >= 0){ // exact fuel is also allowed so >= 0
	        return start;
	    }
	    return -1;
    }

    public static void main(String[] args){
        
    }
}


