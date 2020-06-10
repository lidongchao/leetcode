package qiu12nLcof_64;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n_1 = 3;
        int expect_1 = 6;
        AssertUtils.assertEqualsInteger(expect_1, solution.sumNums(n_1));

        int n_2 = 9;
        int expect_2 = 45;
        AssertUtils.assertEqualsInteger(expect_2, solution.sumNums(n_2));

    }
}
