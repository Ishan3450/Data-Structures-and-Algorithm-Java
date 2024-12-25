import java.util.HashMap;

public class NonRepeatingCharacter {
    static char nonrepeatingCharacter(String S) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (map.get(ch) == 1) {
                return ch;
            }
        }

        return '$';
    }
}
