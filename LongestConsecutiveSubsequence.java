import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    public int longestConsecutive(int[] arr) {
        int longestConsecutiveSeq = 0;

        Set<Integer> track = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int a : arr)
            set.add(a);

        for (int stVal : set) {
            if (track.contains(stVal))
                continue;

            int temp = stVal;
            int currLongestSeq = 0;

            while (set.contains(temp)) {
                temp--;
            }

            // starting of the seq
            temp++;

            while (set.contains(temp)) {
                track.add(temp);
                currLongestSeq++;
                temp++;
            }

            longestConsecutiveSeq = Math.max(longestConsecutiveSeq, currLongestSeq);
        }
        return longestConsecutiveSeq;
    }
}