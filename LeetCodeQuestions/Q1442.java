// https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/?envType=daily-question&envId=2023-12-22

package LeetCodeQuestions;

public class Q1442 {
    public int maxScore(String s) {
        int leftScore = 0;
        int rightScore = 0;

        if (s.charAt(0) == '0') {
            leftScore = 1;
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                rightScore++;
            }
        }

        int maxScore = leftScore + rightScore;

        for (int i = 1; i <= s.length() - 2; i++) {
            if (s.charAt(i) == '0') {
                leftScore++;
            } else {
                rightScore--;
            }

            maxScore = Math.max(maxScore, leftScore + rightScore);
        }

        return maxScore;
    }
}
