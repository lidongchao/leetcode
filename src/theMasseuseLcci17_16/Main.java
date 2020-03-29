package theMasseuseLcci17_16;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        int[] nums_1 = {1,2,3,1};
        int expect_1 = 4;  // 1+0+3+0
        AssertUtils.assertEqualsInteger(expect_1, solution.massage(nums_1));

        int[] nums_2 = {2,7,9,3,1};
        int expect_2 = 12;  // 2+0+9+0+1
        AssertUtils.assertEqualsInteger(expect_2, solution.massage(nums_2));

        int[] nums_3 = {2,1,4,5,3,1,1,3};
        int expect_3 = 12;  // 2+0+4+0+3+0+0+3
        AssertUtils.assertEqualsInteger(expect_3, solution.massage(nums_3));

        int[] nums_4 = {1,2};
        int expect_4 = 2;  // 0+2
        AssertUtils.assertEqualsInteger(expect_4, solution.massage(nums_4));

        int[] nums_5 = {};
        int expect_5 = 0;  // 0
        AssertUtils.assertEqualsInteger(expect_5, solution.massage(nums_5));

        int[] nums_6 = {4};
        int expect_6 = 4;  // 4
        AssertUtils.assertEqualsInteger(expect_6, solution.massage(nums_6));

    }
}
