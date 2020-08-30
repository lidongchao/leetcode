package maximumNumberOfNonOverlappingSubarraysWithSumEqualsTarget5471;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums_1 = {1,1,1,1,1};
        int target_1 = 2;
        int expect_1 = 2;
        AssertUtils.assertEquals( expect_1,
                solution.maxNonOverlapping(nums_1,
                                         target_1));

        int[] nums_2 = {-1,3,5,1,4,2,-9};
        int target_2 = 6;
        int expect_2 = 2;
        AssertUtils.assertEquals( expect_2,
                solution.maxNonOverlapping(nums_2,
                                         target_2));

        int[] nums_3 = {-2,6,6,3,5,4,1,2,8};
        int target_3 = 10;
        int expect_3 = 3;
        AssertUtils.assertEquals( expect_3,
                solution.maxNonOverlapping(nums_3,
                                         target_3));

        int[] nums_4 = {0,0,0};
        int target_4 = 0;
        int expect_4 = 3;
        AssertUtils.assertEquals( expect_4,
                solution.maxNonOverlapping(nums_4,
                                         target_4));

    }
}
