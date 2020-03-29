package topKDesc40;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution6 solution = new Solution6();

        int[] arr_1 = {3,2,1};
        int k_1 = 2;
        int[] expect_1 = {1,2};
        AssertUtils.assertEqualsIntArrayIgnorePosition(expect_1, solution.getLeastNumbers(arr_1, k_1));

        int[] arr_2 = {0,0,0,2,0,5};
        int k_2 = 0;
        int[] expect_2 = {};
        AssertUtils.assertEqualsIntArrayIgnorePosition(expect_2, solution.getLeastNumbers(arr_2, k_2));

    }
}
