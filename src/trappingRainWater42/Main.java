package trappingRainWater42;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();

        int[] height_1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int expect_1 = 6;
        AssertUtils.assertEquals(expect_1, solution.trap(height_1));

        int[] height_2 = {4,2,0,3,2,5};
        int expect_2 = 9;
        AssertUtils.assertEquals(expect_2, solution.trap(height_2));
    }
}
