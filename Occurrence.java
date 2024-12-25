public class Occurrence {
    public static void main(String[] args) {
        int n = 1385757879;
        int target = 7;
        int count = 0;

        while (n > 0) {
            int rem = n % 10;
            if (rem == target) {
                count++;
            }
            n = n / 10;
        }

        System.out.println(count);
    }
}
