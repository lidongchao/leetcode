package zeroOneMatrix542;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int[][] matrix_1 = {
                {0,0,0},
                {0,1,0},
                {0,0,0}};
        int[][] expect_1 = {
                {0,0,0},
                {0,1,0},
                {0,0,0}};
        AssertUtils.assertEquals2DArray(expect_1, solution.updateMatrix(matrix_1));

        int[][] matrix_2 = {
                {0,0,0},
                {0,1,0},
                {1,1,1}};
        int[][] expect_2 = {
                {0,0,0},
                {0,1,0},
                {1,2,1}};
        AssertUtils.assertEquals2DArray(expect_2, solution.updateMatrix(matrix_2));



    }
}
