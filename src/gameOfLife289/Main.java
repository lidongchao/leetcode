package gameOfLife289;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int[][] board_1 = {{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};
        int[][] expect_1 = {{0,0,0}, {1,0,1}, {0,1,1}, {0,1,0}};
        solution.gameOfLife(board_1);
        AssertUtils.assertEqualsInt2DArray(expect_1, board_1);

    }
}
