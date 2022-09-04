public class Recursion {
    public static void main(String[] args){
         print(1);
    }

    static void print(int n){
        // base condition of recursion
        if(n == 5){
            System.out.println(5);
            return;
        }

        // body of the function
        System.out.println(n);

        // recursive call
        print(n+1);
    }
}