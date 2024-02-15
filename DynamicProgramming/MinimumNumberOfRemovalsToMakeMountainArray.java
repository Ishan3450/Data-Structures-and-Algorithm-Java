package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumNumberOfRemovalsToMakeMountainArray {
    public int minimumMountainRemovals(int[] nums) {
        int minRemovals = Integer.MAX_VALUE;

        List<Integer> lis = LIS(nums);
        List<Integer> lds = LDS(nums);

        for (int i = 0; i < lis.size(); i++) {
            if (lis.get(i) == 1 || lds.get(i) == 1) {
                // skipping on this condition because if either of the elem is 1 means either
                // the nums[i] is having no left elements or no right elements
                continue;
            }

            int mountainArraySize = lis.get(i) + lds.get(i) - 1;
            minRemovals = Math.min(minRemovals, nums.length - mountainArraySize);
        }

        return minRemovals;
    }

    private List<Integer> LIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        lis.add(1);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
                lis.add(list.size());
            } else {
                int insertionIdx = Collections.binarySearch(list, nums[i]);

                if (insertionIdx < 0) {
                    insertionIdx = -(insertionIdx + 1);
                }

                list.set(insertionIdx, nums[i]);
                lis.add(list.size());
            }
        }

        return lis;
    }

    private List<Integer> LDS(int[] nums) {
        List<Integer> lds = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(nums[nums.length - 1]);
        lds.add(1);

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
                lds.add(list.size());
            } else {
                int insertionIdx = Collections.binarySearch(list, nums[i]);

                if (insertionIdx < 0) {
                    insertionIdx = -(insertionIdx + 1);
                }

                list.set(insertionIdx, nums[i]);
                lds.add(list.size());
            }
        }

        Collections.reverse(lds);
        return lds;
    }
}
