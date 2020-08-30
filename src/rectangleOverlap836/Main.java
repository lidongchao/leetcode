package rectangleOverlap836;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        int[] rec1_1 = {0,0,2,2};
        int[] rec2_1 = {1,1,3,3};
        boolean expect_1 = true;
        AssertUtils.assertEquals(expect_1, solution.isRectangleOverlap(rec1_1, rec2_1));

        int[] rec1_2 = {0,0,1,1};
        int[] rec2_2 = {1,0,2,1};
        boolean expect_2 = false;
        AssertUtils.assertEquals(expect_2, solution.isRectangleOverlap(rec1_2, rec2_2));
    }
}
