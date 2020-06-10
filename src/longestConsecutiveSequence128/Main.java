package longestConsecutiveSequence128;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution4 solution = new Solution4();

        int[] nums_1 = {100, 4, 200, 1, 3, 2};
        int expect_1 = 4;
        AssertUtils.assertEqualsInteger(expect_1, solution.longestConsecutive(nums_1));

        int[] nums_2 = {0, 0};
        int expect_2 = 1;
        AssertUtils.assertEqualsInteger(expect_2, solution.longestConsecutive(nums_2));

        int[] nums_3 = {0, -1};
        int expect_3 = 2;
        AssertUtils.assertEqualsInteger(expect_3, solution.longestConsecutive(nums_3));

    }
}
