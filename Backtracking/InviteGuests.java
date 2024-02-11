package Backtracking;

public class InviteGuests {
    static int callGuests(int n){
        // base condition
        if(n <= 1){ // if single guest is there or not guests is there, only 1 way it is to invite.
            return 1;
        }

        // funciton body
        // way1 is without pair
        int way1 = callGuests(n-1);

        // way2 is with pair, where n-1 is the pairs of guests and the recursive call is the remaining guests
        int way2 = (n-1) * callGuests(n-2);

        return way1 + way2;
    }

    public static void main(String[] args){
        int n = 100;
        System.out.println(callGuests(n));
    }
}
