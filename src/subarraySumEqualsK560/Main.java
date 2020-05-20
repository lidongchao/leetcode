package subarraySumEqualsK560;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int[] nums_1 = {1,1,1};
        int k_1 = 2;
        int expect_1 = 2;
        AssertUtils.assertEqualsInteger(expect_1, solution.subarraySum(nums_1, k_1));

        int[] nums_2 = {1};
        int k_2 = 0;
        int expect_2 = 0;
        AssertUtils.assertEqualsInteger(expect_2, solution.subarraySum(nums_2, k_2));
    }
}
