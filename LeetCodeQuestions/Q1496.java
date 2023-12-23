package LeetCodeQuestions;
import java.util.HashSet;
import javafx.util.Pair;

public class Q1496 {
        public boolean isPathCrossing(String path) {
        // Pair: {verticalDist, horizontalDist}
        HashSet<Pair<Integer, Integer>> set = new HashSet<>();
        set.add(new Pair<>(0,0));

        int verticalDist = 0;
        int horizontalDist = 0;

        for(int i = 0 ; i < path.length(); i++){
            char curr = path.charAt(i);

            if(curr == 'S'){
                verticalDist--;
            } else if(curr == 'N'){
                verticalDist ++;
            } else if(curr == 'W'){
                horizontalDist --;
            } else {
                horizontalDist ++;
            }

            Pair p = new Pair<>(verticalDist, horizontalDist);

            if(set.contains(p)){
                return true;
            }
            set.add(p);
        }
        return false;
    }
}
