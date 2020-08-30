package maximalSquare221;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        char[][] matrix_1 = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        int expect_1 = 4;
        AssertUtils.assertEquals(expect_1, solution.maximalSquare(matrix_1));

        char[][] matrix_2 = {
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'}};
        int expect_2 = 9;
        AssertUtils.assertEquals(expect_2, solution.maximalSquare(matrix_2));



    }
}
