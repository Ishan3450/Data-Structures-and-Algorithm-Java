public class Recursion {
    public static void main(String[] args){
         print(5);
    }

    static void print(int n){
        // base condition of recursion
        if(n == 0){
            return;
        }

        // body of the function
        System.out.print(n + " ");

        // recursive call
        print(n-1);
    }
}