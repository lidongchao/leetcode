package minimumIncrementToMakeArrayUnique945;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        int[] A_1 = {1,2,2};
        int expect_1 = 1;  // [1,2,2] -> [1,2,3]
        AssertUtils.assertEquals(expect_1, solution.minIncrementForUnique(A_1));

        int[] A_2 = {3,2,1,2,1,7};
        int expect_2 = 6;  // [3,2,1,2,1,7] -> [3,4,1,2,5,7]
        AssertUtils.assertEquals(expect_2, solution.minIncrementForUnique(A_2));

    }
}
