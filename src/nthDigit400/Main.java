package nthDigit400;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        int n_1 = 3;
        int expect_1 = 3;  // 12[3]
        AssertUtils.assertEqualsInteger(expect_1, solution.findNthDigit(n_1));

        int n_2 = 9;
        int expect_2 = 9;  // 12345678[9]
        AssertUtils.assertEqualsInteger(expect_2, solution.findNthDigit(n_2));

        int n_3 = 10;
        int expect_3 = 1;  // 123456789[1]
        AssertUtils.assertEqualsInteger(expect_3, solution.findNthDigit(n_3));

        int n_4 = 11;
        int expect_4 = 0;  // 1234567891[0]
        AssertUtils.assertEqualsInteger(expect_4, solution.findNthDigit(n_4));

    }
}
