import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacter {
    public String FirstNonRepeating(String A) {
        // code here
        StringBuilder ans = new StringBuilder("");
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();

        for (char ch : A.toCharArray()) {
            // add the curr character or update the freqeuency of the curr character
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // add the curr character in the queue
            q.add(ch);

            // loop will run until queue not becomes empty
            while (!q.isEmpty()) {
                // first check the frequency of the element in the front of the queue
                if (map.get(q.peek()) > 1) {
                    q.poll(); // remove it from the queue
                } else { // ch appeared first time only
                    ans.append(q.peek());
                    break;
                }
            }

            if (q.isEmpty()) { // is empty queue is found means repeating characters found
                ans.append('#');
            }
        }

        return ans.toString();
    }
}
