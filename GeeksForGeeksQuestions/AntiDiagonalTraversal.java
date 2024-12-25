import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class AntiDiagonalTraversal {
     public int[] antiDiagonalPattern(int[][] matrix)
    {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        
        for(int r = 0 ; r < matrix.length; r ++){
            for(int c = 0 ; c < matrix.length; c++){
                int key = r + c;
                
                if(map.containsKey(key)){
                    map.get(key).add(matrix[r][c]);
                } else{
                    List<Integer> list = new ArrayList<>();
                    list.add(matrix[r][c]);
                    map.put(key, list);
                }
            }
        }
        
        int[] ans = new int[matrix.length * matrix.length];
        int idx = 0;
        
        for(List<Integer> list: map.values()){
            for(int value: list){
                ans[idx++] = value;
            }
        }
        return ans;
    }
}
