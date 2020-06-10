package spiralMatrix54;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[][] matrix_1 = {
//            {1, 2, 3 },
//            {4, 5, 6 },
//            {7, 8, 9 }
//        };
//        int[] expect_1 = {1,2,3,6,9,8,7,4,5};
//        AssertUtils.assertEqualsIntArray(expect_1,
//                solution.spiralOrder(matrix_1).stream().mapToInt(Integer::intValue).toArray());
//
//        int[][] matrix_2 = {
//            {1, 2, 3, 4 },
//            {5, 6, 7, 8 },
//            {9, 10, 11, 12 }
//        };
//        int[] expect_2 = {1,2,3,4,8,12,11,10,9,5,6,7};
//        AssertUtils.assertEqualsIntArray(expect_2,
//                solution.spiralOrder(matrix_2).stream().mapToInt(Integer::intValue).toArray());

        int[][] matrix_3 = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
        };
        int[] expect_3 = {1,2,3,4,5,6,7,8,9,10};
        AssertUtils.assertEqualsIntArray(expect_3,
                solution.spiralOrder(matrix_3).stream().mapToInt(Integer::intValue).toArray());
    }
}
