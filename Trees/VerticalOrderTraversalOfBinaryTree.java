package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

import javafx.util.Pair;

public class VerticalOrderTraversalOfBinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        /* Map{col, SubMap{ row, {list of elems} } } */
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();

        /* struct: < (r,c), TreeNode > */
        Queue<Pair<Pair<Integer, Integer>, TreeNode>> q = new LinkedList<>();

        q.add(new Pair<>(new Pair<>(0, 0), root));

        while (!q.isEmpty()) {
            TreeNode frontNode = q.peek().getValue();
            int frontRow = q.peek().getKey().getKey();
            int frontCol = q.peek().getKey().getValue();

            if (!map.containsKey(frontCol)) {
                List<Integer> list = new ArrayList<>();
                list.add(frontNode.val);
                TreeMap<Integer, List<Integer>> subMap = new TreeMap<>();
                subMap.put(frontRow, list);
                map.put(frontCol, subMap);
            } else {
                TreeMap<Integer, List<Integer>> subMap = map.get(frontCol);
                if (!subMap.containsKey(frontRow)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(frontNode.val);
                    subMap.put(frontRow, list);
                } else {
                    subMap.get(frontRow).add(frontNode.val);
                }
            }

            if (frontNode.left != null) {
                q.add(new Pair<>(new Pair<>(frontRow + 1, frontCol - 1), frontNode.left));
            }

            if (frontNode.right != null) {
                q.add(new Pair<>(new Pair<>(frontRow + 1, frontCol + 1), frontNode.right));
            }

            q.remove();
        }

        // creating answer
        List<List<Integer>> ans = new ArrayList<>();
        for (TreeMap<Integer, List<Integer>> subMap : map.values()) {
            List<Integer> l = new ArrayList<>();
            for (List<Integer> list : subMap.values()) {
                Collections.sort(list);
                l.addAll(list);
            }
            ans.add(l);
        }
        return ans;
    }
}
// (r,c)
// < < > >
// col row val
// -2 2 4
// -1 1 2
// 0 0 1
// 2 6, 5
// 1 1 3
// 2 2 7

// [[4],[2],[1,5,6],[3],[7]]
