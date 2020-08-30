package permutations46;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int[] nums_1 = {1,2,3};
        int expect_1 = 6;
        AssertUtils.assertEquals(expect_1, solution.permute(nums_1).size());
    }
}
