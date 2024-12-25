package LeetCodeQuestions;

import java.util.*;

public class Q2610 {
    public List<List<Integer>> findMatrix(int[] nums) {
        int minSize = 0;

        for (int i = 0; i < nums.length; i++) {
            minSize = Math.max(nums[i], minSize);
        }

        int[] occr = new int[minSize];

        for (int i = 0; i < nums.length; i++) {
            occr[nums[i] - 1]++;
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < occr.length; i++) {
            int row = 0;
            while (occr[i] > 0) {
                if (map.containsKey(row)) {
                    map.get(row).add(i + 1);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i + 1);
                    map.put(row, list);
                }
                row++;
                occr[i]--;
            }
        }

        List<List<Integer>> matrix = new ArrayList<>();
        for (List<Integer> list : map.values()) {
            matrix.add(list);
        }

        return matrix;
    }
}