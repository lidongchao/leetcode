package productOfArrayExceptSelf238;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int[] nums_1 = {1,2,3,4};
        int[] expect_1 = {24,12,8,6};
        AssertUtils.assertEqualsIntArray(expect_1, solution.productExceptSelf(nums_1));
    }
}
