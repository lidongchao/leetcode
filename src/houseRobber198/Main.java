package houseRobber198;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums_1 = {1,2,3,1};
        int expect_1 = 4;
        AssertUtils.assertEquals(expect_1, solution.rob(nums_1));

        int[] nums_2 = {2,7,9,3,1};
        int expect_2 = 12;
        AssertUtils.assertEquals(expect_2, solution.rob(nums_2));

    }
}
