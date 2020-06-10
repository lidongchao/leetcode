package findTheDuplicateNumber287;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums_1 = {1,3,4,2,2};
        int expect_1 = 2;
        AssertUtils.assertEqualsInteger(expect_1, solution.findDuplicate(nums_1));

    }
}
