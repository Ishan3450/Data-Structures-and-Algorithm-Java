public class ShiftingLetters {
    public String shiftingLetters(String s, int[] shifts) {
        int suffixSum = 0;
        StringBuilder shiftedStr = new StringBuilder();

        for (int i = shifts.length - 1; i >= 0; i--) {
            suffixSum += shifts[i] % 26;
            int shiftedCharAscii = ((suffixSum % 26) + ((int) s.charAt(i) - 'a')) % 26;
            shiftedStr.append((char) (shiftedCharAscii + 'a'));
        }
        return shiftedStr.reverse().toString();
    }
}
