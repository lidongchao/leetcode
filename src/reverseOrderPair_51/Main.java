package reverseOrderPair_51;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums_1 = {7,5,6,4};
        int expect_1 = 5;
        AssertUtils.assertEquals(expect_1, solution.reversePairs(nums_1));

    }
}
