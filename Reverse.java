public class Reverse{
    public static void main(String[] args){
        int n = 123456789;
        int rev_num = 0;
        
        while(n > 0){
            int rem = n % 10;
            rev_num = rev_num * 10 + rem;
            n = n / 10;
        }

        System.out.println(rev_num);
    }
} 
