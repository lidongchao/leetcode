package sumOfMutatedArrayClosestToTarget1300;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int[] arr_1 = {4, 9, 3};
        int target_1 = 10;
        int expect_1 = 3;
        AssertUtils.assertEqualsInteger(expect_1, solution.findBestValue(arr_1, target_1));

        int[] arr_2 = {2, 3, 5};
        int target_2 = 10;
        int expect_2 = 5;
        AssertUtils.assertEqualsInteger(expect_2, solution.findBestValue(arr_2, target_2));

        int[] arr_3 = {60864, 25176, 27249, 21296, 20204};
        int target_3 = 56803;
        int expect_3 = 11361;
        AssertUtils.assertEqualsInteger(expect_3, solution.findBestValue(arr_3, target_3));

        int[] arr_4 = {2, 3, 5};
        int target_4 = 11;
        int expect_4 = 5;
        AssertUtils.assertEqualsInteger(expect_4, solution.findBestValue(arr_4, target_4));

    }
}
