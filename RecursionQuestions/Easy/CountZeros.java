package RecursionQuestions.Easy;

public class CountZeros {
    public static void main(String[] args){
        int n = 30210004;

        System.out.println(countZeroes(n, 0));
    }

    static int countZeroes(int n, int count){
        // base condition
        if(n == 0){
            return count;
        }

        // function body
        int rem = n % 10;

        // recursive calls and condition
        if(rem == 0){
            return countZeroes(n/10, count+1);
        }

        return countZeroes(n/10, count);
    }
}
