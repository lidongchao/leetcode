package rotateMatrixLcci_01_07;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix_1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] expect_1 = {
                {7,4,1},
                {8,5,2},
                {9,6,3}
        };
        solution.rotate(matrix_1);
        AssertUtils.assertEqualsInt2DArray(expect_1, matrix_1);

        int[][] matrix_2 = {
                { 5, 1, 9,11},
                { 2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        int[][] expect_2 = {
                {15,13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7,10,11}
        };
        solution.rotate(matrix_2);
        AssertUtils.assertEqualsInt2DArray(expect_2, matrix_2);

    }
}
