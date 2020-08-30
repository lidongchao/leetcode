package numberOfIslands200;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        char[][] grid_1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };
        int expect_1 = 1;
        AssertUtils.assertEquals(expect_1, solution.numIslands(grid_1));

        char[][] grid_2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };
        int expect_2 = 3;
        AssertUtils.assertEquals(expect_2, solution.numIslands(grid_2));


    }
}
