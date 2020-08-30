package asFarFromLandAsPossible1162;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        int[][] grid_1 = {{1,0,1},{0,0,0},{1,0,1}};
        int expect_1 = 2;
        AssertUtils.assertEquals(expect_1, solution.maxDistance(grid_1));

        int[][] grid_2 = {{1,0,0},{0,0,0},{0,0,0}};
        int expect_2 = 4;
        AssertUtils.assertEquals(expect_2, solution.maxDistance(grid_2));

        int[][] grid_3 = {{0,0,0},{0,0,0},{0,0,0}};
        int expect_3 = -1;
        AssertUtils.assertEquals(expect_3, solution.maxDistance(grid_3));

        int[][] grid_4 = {{1,1,1},{1,1,1},{1,1,1}};
        int expect_4 = -1;
        AssertUtils.assertEquals(expect_4, solution.maxDistance(grid_4));
    }
}
