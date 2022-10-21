/* 
 * Solved Using Recursion 
 * Time Complexities: O(2N)
 */

public class TowerOfHanoi {
    public static void towerOfHanoi(int n, String source, String helper, String destination){
        // base condition
        if(n == 1){ // if only 1 disk is there it means we can directly transfer it to destination
            System.out.println("Transferring disk " + n + " from " + source + " to " + destination);
            return;
        }

        // function body
        
        // first we will transfer n-1 disks to the helper string
        /*
         * In below recursion call:
         * - we are transferring from source to helper and using destination as helper
         * 
         * @params
         * - source: source
         * - helper: destination
         * - destination: helper 
         */
        towerOfHanoi(n-1, source, destination, helper);
        System.out.println("Transferring disk " + n + " from " + source + " to " + destination);
        /* 
         * after transferring n-1 disks base condition will hit due to which the nth disk will already transferred to the destination
         * so now we have to take care of the n-1 disks which are in helper string
        */

        /*
         * In below recursion call:
         * - now we are transferring n-1 disks from the helper to the destination
         * 
         * @params
         * - source: helper (in which n-1 disks are there)
         * - helper: source (at this point source will be empty)
         * - destination: destination
         */
        towerOfHanoi(n-1, helper, source, destination);

        // that's it we have transferred all the disks
    }

    public static void main(String[] args){
        int disks = 3;

        towerOfHanoi(disks, "SRC", "HELP", "DEST");
    }
}
