public class NewtonRaphsonSQRT {
    public static void main(String[] args){
        System.out.println(sqrt(36));
    }

    static double sqrt(int n){
        double x = n;
        double root = 0;

        while(true){ // inifinite running the loop till we are able to minimize the error
            // * formula of Newton Raphson SQRT
            root = 0.5 * (x + (n/x));

            if(Math.abs(root - x) < 1){
                break;
            }

            // trying to minimize the error
            x = root;
        }

        return root;
    }
}
