package climbingStairs70;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int n_1 = 2;
        int expect_1 = 2;
        AssertUtils.assertEqualsInteger(expect_1, solution.climbStairs(n_1));

        int n_2 = 3;
        int expect_2 = 3;
        AssertUtils.assertEqualsInteger(expect_2, solution.climbStairs(n_2));

        int n_3 = 45;
        int expect_3 = 1836311903;
        AssertUtils.assertEqualsInteger(expect_3, solution.climbStairs(n_3));
    }
}
