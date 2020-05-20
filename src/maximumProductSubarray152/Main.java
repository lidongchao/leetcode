package maximumProductSubarray152;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int[] nums_1 = {2,3,-2,4};
        int expect_1 = 6;
        AssertUtils.assertEqualsInteger(expect_1, solution.maxProduct(nums_1));

        int[] nums_2 = {-2,0,-1};
        int expect_2 = 0;
        AssertUtils.assertEqualsInteger(expect_2, solution.maxProduct(nums_2));

        int[] nums_3 = {0,2};
        int expect_3 = 2;
        AssertUtils.assertEqualsInteger(expect_3, solution.maxProduct(nums_3));
    }
}
