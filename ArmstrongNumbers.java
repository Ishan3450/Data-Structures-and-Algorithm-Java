public class ArmstrongNumbers{
    public static void main(String[] args){
        boolean result = isArmstrong(153);

        System.out.println(result);
    }   

    static boolean isArmstrong(int n){

        int sum = 0;
        int n_copy = n;

        while(n > 0){
            int rem = n % 10;
            int cube_of_rem = rem * rem * rem;
            sum += cube_of_rem;
            n = n / 10;
        }

        if(sum == n_copy){
            return true;
        } else{
            return false;
        }

    }
}
