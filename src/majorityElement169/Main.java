package majorityElement169;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        int[] nums_1 = {3,2,3};
        int expect_1 = 3;
        AssertUtils.assertEquals(expect_1, solution.majorityElement(nums_1));

        int[] nums_2 = {2,2,1,1,1,2,2};
        int expect_2 = 2;
        AssertUtils.assertEquals(expect_2, solution.majorityElement(nums_2));

    }
}
