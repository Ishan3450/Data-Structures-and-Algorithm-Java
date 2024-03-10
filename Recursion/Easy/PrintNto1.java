package Recursion.Easy;

import java.text.BreakIterator;

public class PrintNto1 {
    public static void main(String[] args){
        printFromN(5);
    }

    static void printFromN(int n){
        // base condition
        if(n == 0){
            return;
        }

        // funciton body
        System.out.print(n + " ");

        // recursive consition
        printFromN(n-1);
    }
}
