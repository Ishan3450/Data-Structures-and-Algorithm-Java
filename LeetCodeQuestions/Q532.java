package LeetCodeQuestions;

import java.util.Arrays;
import java.util.HashSet;

import javafx.util.Pair;

public class Q532 {
    // approach 1: Two-pointers method
    public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        HashSet<Pair<Integer, Integer>> set = new HashSet<>();
        int i = 0, j = 1;

        while (j < nums.length) {
            int diff = nums[j] - nums[i];

            if (diff == k) {
                set.add(new Pair<>(nums[i], nums[j]));
                j++;
            } else if (diff > k) {
                i++;
            } else {
                j++;
            }

            if (i == j) {
                j++;
            }
        }

        return set.size();
    }

    // approach 2: Binary Search approach
    public boolean bs(int[] nums, int start, int target) {
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }

    public int findPairs2(int[] nums, int k) {
        Arrays.sort(nums);
        HashSet<Pair<Integer, Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (bs(nums, i + 1, nums[i] + k)) {
                set.add(new Pair<>(nums[i], nums[i] + k));
            }
        }

        return set.size();
    }

    public static void main(String[] args) {

    }
}
