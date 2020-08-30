package rottingOranges994;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution3 solution = new Solution3();

        int[][] grid_1 = {{2,1,1},{1,1,0},{0,1,1}};
        int expect_1 = 4;
        AssertUtils.assertEquals(expect_1, solution.orangesRotting(grid_1));

        int[][] grid_2 = {{2,1,1},{0,1,1},{1,0,1}};
        int expect_2 = -1;
        AssertUtils.assertEquals(expect_2, solution.orangesRotting(grid_2));

        int[][] grid_3 = {{0,2}};
        int expect_3 = 0;
        AssertUtils.assertEquals(expect_3, solution.orangesRotting(grid_3));

        int[][] grid_4 = {{0,0,1,2},{2,0,1,1}};
        int expect_4 = 2;
        AssertUtils.assertEquals(expect_4, solution.orangesRotting(grid_4));

        int[][] grid_5 = {{1,0,0,0,2,1,0}};
        int expect_5 = -1;
        AssertUtils.assertEquals(expect_5, solution.orangesRotting(grid_5));
    }
}
