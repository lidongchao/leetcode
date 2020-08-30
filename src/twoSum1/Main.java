package twoSum1;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int[] nums_1 = {2,7,11,15};
        int target_1 = 9;
        int[] expect_1 = {0,1};

        AssertUtils.assertEqualsArray(expect_1, solution.twoSum(nums_1, target_1));

    }
}
