/*
 * - * * * *
 * - * * *
 * - * *
 * - *
 */

package Recursion.Patterns;

public class Pattern1 {
    public static void main(String[] args){
        // pattern(5);
        pattern_recursion(5, 0);
    }

    static void pattern(int n){
        for(int i=n; i>=1; i--){
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern_recursion( int row, int col){
        // base condition
        if(row == 0){
            return;
        }

        // function body
        if(col == row){
            System.out.println();
            pattern_recursion( row-1, 0);
        } else{
            System.out.print("* ");
            pattern_recursion( row, col+1);
        }
    }

}
