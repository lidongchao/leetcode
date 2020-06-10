package largestRectangleInHistogram84;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution3 solution = new Solution3(true);

        int[] heights_1 = {2,1,5,6,2,3};
        int expect_1 = 10;
        AssertUtils.assertEqualsInteger(expect_1, solution.largestRectangleArea(heights_1));

        int[] heights_2 = {1};
        int expect_2 = 1;
        AssertUtils.assertEqualsInteger(expect_2, solution.largestRectangleArea(heights_2));

        int[] heights_3 = {1,1};
        int expect_3 = 2;
        AssertUtils.assertEqualsInteger(expect_3, solution.largestRectangleArea(heights_3));

        int[] heights_4 = {3,5,4,3,2,1};
        int expect_4 = 12;
        AssertUtils.assertEqualsInteger(expect_4, solution.largestRectangleArea(heights_4));

    }
}
