package Strings;

public class SubsequencesByBabbar {
    public static void main(String[] args) {
        String s = "abc";

        subseq(s, "", 0);
    }

    public static void subseq(String s, String processed, int idx) {
        // base condition
        if (idx == s.length()) {
            System.out.println(processed);
            return;
        }

        // function body

        // include call
        subseq(s, processed + s.charAt(idx), idx + 1);

        // exclude call
        subseq(s, processed, idx + 1);
    }
}
