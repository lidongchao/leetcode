package maxAreaOfIsland695;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        int[][] grid_1 = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                          {0,0,0,0,0,0,0,1,1,1,0,0,0},
                          {0,1,1,0,1,0,0,0,0,0,0,0,0},
                          {0,1,0,0,1,1,0,0,1,0,1,0,0},
                          {0,1,0,0,1,1,0,0,1,1,1,0,0},
                          {0,0,0,0,0,0,0,0,0,0,1,0,0},
                          {0,0,0,0,0,0,0,1,1,1,0,0,0},
                          {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int expect_1 = 6;
        AssertUtils.assertEqualsInteger(expect_1, solution.maxAreaOfIsland(grid_1));

        int[][] grid_2 = {{1}};
        int expect_2 = 1;
        AssertUtils.assertEqualsInteger(expect_2, solution.maxAreaOfIsland(grid_2));

        int[][] grid_3 = {{1,1},{1,0}};
        int expect_3 = 3;
        AssertUtils.assertEqualsInteger(expect_3, solution.maxAreaOfIsland(grid_3));
    }
}
