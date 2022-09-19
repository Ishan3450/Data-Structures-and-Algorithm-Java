package RecursionQuestions.Easy;

public class Print1ToN {
    public static void main(String[] args){
        printTillN(5);
    }

    static void printTillN(int n){
        // base condition
        if(n == 0){
            return;
        }

        // recursive condition
        printTillN(n-1);
        
        // print the numbers after emptying the stack so it will work in that manner
        System.out.println(n);
    }
}
