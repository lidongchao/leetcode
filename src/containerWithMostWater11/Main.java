package containerWithMostWater11;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] height_1 = {1,8,6,2,5,4,8,3,7};
        int expect_1 = 49;
        AssertUtils.assertEquals(expect_1, solution.maxArea(height_1));
    }
}
