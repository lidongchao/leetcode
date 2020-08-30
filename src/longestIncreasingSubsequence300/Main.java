package longestIncreasingSubsequence300;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();

        int[] nums_1 = {10,9,2,5,3,7,101,18};
        int expect_1 = 4;  // 最长的上升子序列是 [2,3,7,18]，它的长度是 4
        AssertUtils.assertEquals(expect_1, solution.lengthOfLIS(nums_1));

        int[] nums_2 = {2,2};
        int expect_2 = 1;  // 最长的上升子序列是 [2]，它的长度是 1
        AssertUtils.assertEquals(expect_2, solution.lengthOfLIS(nums_2));

        int[] nums_3 = {4,10,4,3,8,9};
        int expect_3 = 3;  // 最长的上升子序列是 [3,8,9]，它的长度是 3
        AssertUtils.assertEquals(expect_3, solution.lengthOfLIS(nums_3));

    }
}
