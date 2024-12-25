package LeetCodeQuestions;

public class Q1758 {
    public int minOperations(String s) {
        int startingFromOne = count(s, true);
        int startingFromZero = count(s, false);

        return Math.min(startingFromOne, startingFromZero);
    }

    private int count(String s, boolean toCheck) {
        // toCheck true means string starting from 1
        // toCheck false means string starting from 0

        int changesCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == '1' && !toCheck) || (s.charAt(i) == '0' && toCheck)) {
                changesCount++;
            }
            toCheck = !toCheck;
        }
        return changesCount;
    }
}
