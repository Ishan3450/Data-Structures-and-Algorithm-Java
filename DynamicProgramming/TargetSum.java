package DynamicProgramming;

import java.util.HashMap;
import java.util.Objects;

public class TargetSum {
    /*
     * Here memoization on normal array would not work as negative target may come
     * inbetween the expression creation, and in between means there is no gurantee
     * that if negative comes means no ans is there.
     */
    private class Pair {
        int idx;
        int target;

        Pair(int idx, int target) {
            this.idx = idx;
            this.target = target;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (o == null || o.getClass() != this.getClass()) {
                return false;
            }

            Pair p = (Pair) o;
            return this.idx == p.idx && this.target == p.target;
        }

        @Override
        public int hashCode() {
            return Objects.hash(idx, target);
        }
    }

    public int findTargetSumWays(int[] nums, int target) {
        HashMap<Pair, Integer> dp = new HashMap<>();

        // return memoization(nums, target, 0, dp);
        return tabulation(nums, target);
    }

    // tabulation
    public int tabulation(int[] nums, int target) {
        HashMap<Pair, Integer> dp = new HashMap<>();
        dp.put(new Pair(nums.length, 0), 1);

        int total = 0;
        for (int elem : nums)
            total += elem;

        for (int idx = nums.length - 1; idx >= 0; idx--) {
            for (int t = -total; t <= total; t++) {

                int addingPlusSign = dp.get(new Pair(idx + 1, t - nums[idx])) == null ? 0
                        : dp.get(new Pair(idx + 1, t - nums[idx]));
                int addingMinusSign = dp.get(new Pair(idx + 1, t + nums[idx])) == null ? 0
                        : dp.get(new Pair(idx + 1, t + nums[idx]));

                dp.put(new Pair(idx, t), addingPlusSign + addingMinusSign);
            }
        }

        return dp.get(new Pair(0, target)) == null ? 0 : dp.get(new Pair(0, target));
    }

    // memoization
    public int memoization(int[] nums, int target, int idx, HashMap<Pair, Integer> dp) {
        // base condition
        if (idx >= nums.length) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }

        Pair p = new Pair(idx, target);

        if (dp.containsKey(p)) {
            return dp.get(p);
        }

        // function body
        int addingPlusSign = memoization(nums, target - nums[idx], idx + 1, dp);
        int addingMinusSign = memoization(nums, target - (-nums[idx]), idx + 1, dp);

        dp.put(p, addingPlusSign + addingMinusSign);
        return dp.get(p);
    }

    // recursive
    public int recursive(int[] nums, int target, int idx) {
        // base condition
        if (idx >= nums.length) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }

        // function body
        int addingPlusSign = recursive(nums, target - nums[idx], idx + 1);
        int addingMinusSign = recursive(nums, target - (-nums[idx]), idx + 1);

        return addingPlusSign + addingMinusSign;
    }
}
