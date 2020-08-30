package surfaceAreaOf3dShapes892;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        int[][] grid_1 = {{2}};
        int expect_1 = 10;
        AssertUtils.assertEquals(expect_1, solution.surfaceArea(grid_1));

        int[][] grid_2 = {{1,2},{3,4}};
        int expect_2 = 34;
        AssertUtils.assertEquals(expect_2, solution.surfaceArea(grid_2));

        int[][] grid_3 = {{1,0},{0,2}};
        int expect_3 = 16;
        AssertUtils.assertEquals(expect_3, solution.surfaceArea(grid_3));

        int[][] grid_4 = {{1,1,1},{1,0,1},{1,1,1}};
        int expect_4 = 32;
        AssertUtils.assertEquals(expect_4, solution.surfaceArea(grid_4));

        int[][] grid_5 = {{2,2,2},{2,1,2},{2,2,2}};
        int expect_5 = 46;
        AssertUtils.assertEquals(expect_5, solution.surfaceArea(grid_5));

    }
}
