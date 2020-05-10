package singleNumbers_56_I;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums_1 = {4,1,4,6};
        int[] expect_1 = {1,6};
        AssertUtils.assertEqualsIntArrayIgnorePosition(expect_1, solution.singleNumbers(nums_1));

        int[] nums_2 = {1,2,10,4,1,4,3,3};
        int[] expect_2 = {2, 10};
        AssertUtils.assertEqualsIntArrayIgnorePosition(expect_2, solution.singleNumbers(nums_2));

    }
}
