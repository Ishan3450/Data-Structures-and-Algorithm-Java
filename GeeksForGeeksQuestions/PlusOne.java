// ! Not working for the inputs having 9

import java.util.ArrayList;
import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(9);
        arr.add(9);
        arr.add(9);

        int N = 3;

        System.out.println(increment(arr, N));

    }

    static ArrayList<Integer> increment(ArrayList<Integer> arr, int N) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();

        int arrIntNum = arrToInt(arr);
        arrIntNum += 1;

        arrIntNum = reverseTheNum(arrIntNum);

        while (arrIntNum > 0) {
            int last = arrIntNum % 10;
            ans.add(last);
            arrIntNum /= 10;
        }
        return ans;
    }

    static int arrToInt(ArrayList<Integer> arr) {
        int temp = 0;

        System.out.println("aa to int");
        for (int i = 0; i < arr.size(); i++) {
            temp = temp * 10 + arr.get(i);
        }

        return temp;
    }

    static int reverseTheNum(int n) {
        int temp = 0;

        while (n > 0) {
            int last = n % 10;
            temp = temp * 10 + last;
            n /= 10;
        }

        return temp;
    }
}
