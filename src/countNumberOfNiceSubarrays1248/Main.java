package countNumberOfNiceSubarrays1248;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums_1 = {1,1,2,1,1};
        int k_1 = 3;
        int expect_1 = 2;
        AssertUtils.assertEqualsInteger(expect_1, solution.numberOfSubarrays(nums_1, k_1));

        int[] nums_2 = {2,4,6};
        int k_2 = 1;
        int expect_2 = 0;
        AssertUtils.assertEqualsInteger(expect_2, solution.numberOfSubarrays(nums_2, k_2));

        int[] nums_3 = {2,2,2,1,2,2,1,2,2,2};
        int k_3 = 2;
        int expect_3 = 16;
        AssertUtils.assertEqualsInteger(expect_3, solution.numberOfSubarrays(nums_3, k_3));

        int[] nums_4 = {1,1,1,1,1};
        int k_4 = 1;
        int expect_4 = 5;
        AssertUtils.assertEqualsInteger(expect_4, solution.numberOfSubarrays(nums_4, k_4));
    }
}
