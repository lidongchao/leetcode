package searchInRotatedSortedArray33;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int[] nums_1 = {4,5,6,7,0,1,2};
        int target_1 = 0;
        int expect_1 = 4;
        AssertUtils.assertEquals(expect_1, solution.search(nums_1, target_1));

        int[] nums_2 = {4,5,6,7,0,1,2};
        int target_2 = 3;
        int expect_2 = -1;
        AssertUtils.assertEquals(expect_2, solution.search(nums_2, target_2));

    }
}
