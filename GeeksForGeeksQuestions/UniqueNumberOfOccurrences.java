import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberOfOccurrences {
        public static boolean isFrequencyUnique(int n, int[] arr) {
        HashMap<Integer, Integer> track = new HashMap<>();
        for(int elem: arr){
            track.put(elem, track.getOrDefault(elem, 0) + 1);
        }

        return new HashSet<>(track.values()).size() == track.size() ? true : false;
    }
}
