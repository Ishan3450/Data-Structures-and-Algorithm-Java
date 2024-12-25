import java.util.Arrays;

public class FirstAndLastOccurrenceOfElementInString {
    public static int[] getIndices(String s, char key, int index, int leftMost, int rightMost) {
        // base condition
        if (index == s.length()) {
            return new int[] { leftMost, rightMost };
        }

        // function body
        char curr = s.charAt(index);

        if (curr == key && leftMost == -1) {
            leftMost = index;
        } else {
            rightMost = index;
        }

        return getIndices(s, key, index + 1, leftMost, rightMost);
    }

    public static void main(String[] args) {
        String str = "aaaaa";
        char key = 'a';

        System.out.println(Arrays.toString(getIndices(str, key, 0, -1, -1)));
    }
}
