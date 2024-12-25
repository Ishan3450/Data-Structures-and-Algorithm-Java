// https://codeforces.com/problemset/problem/4/A

package CodeForcesQuestions;

import java.util.Scanner;

public class Watermelon {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        isDivisible(n);
        sc.close();
    }

    static void isDivisible(int n){
        if(n%2==0){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
    }

    
}
