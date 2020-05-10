package sqrtx69;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int x_1 = 4;
        int expect_1 = 2;
        AssertUtils.assertEqualsInteger(expect_1, solution.mySqrt(x_1));

        int x_2 = 8;
        int expect_2 = 2;
        AssertUtils.assertEqualsInteger(expect_2, solution.mySqrt(x_2));

        int x_3 = 1;
        int expect_3 = 1;
        AssertUtils.assertEqualsInteger(expect_3, solution.mySqrt(x_3));

        int x_4 = 2147395599;
        int expect_4 = 46339;
        AssertUtils.assertEqualsInteger(expect_4, solution.mySqrt(x_4));
    }
}
