public class ShiftingLetters2 {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] diff = new int[s.length()];

        for (int i = 0; i < shifts.length; i++) {
            int L = shifts[i][0];
            int R = shifts[i][1];

            diff[L] += shifts[i][2] == 1 ? 1 : -1;

            if (diff[L] < 0)
                diff[L] += 26;
            else if (diff[L] >= 26)
                diff[L] -= 26;

            if (shifts[i][1] < diff.length - 1) {
                diff[R + 1] += shifts[i][2] == 1 ? -1 : 1;

                if (diff[R + 1] < 0)
                    diff[R + 1] += 26;
                else if (diff[R + 1] >= 26)
                    diff[R + 1] -= 26;
            }
        }

        StringBuilder shiftedString = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = (sum + diff[i]) % 26;
            int shiftedCharAscii = (sum + ((int) s.charAt(i) - 'a')) % 26;
            shiftedString.append((char) (shiftedCharAscii + 'a'));
        }

        return shiftedString.toString();
    }
}
