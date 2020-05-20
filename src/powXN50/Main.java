package powXN50;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        double x_1 = 2.00000;
        int n_1 = 10;
        double expect_1 = 1024.00000;
        AssertUtils.assertEqualsDouble(expect_1, solution.myPow(x_1, n_1));

        double x_2 = 2.10000;
        int n_2 = 3;
        double expect_2 = 9.26100;
        AssertUtils.assertEqualsDouble(expect_2, solution.myPow(x_2, n_2));

        double x_3 = 2.00000;
        int n_3 = -2;
        double expect_3 = 0.25000;
        AssertUtils.assertEqualsDouble(expect_3, solution.myPow(x_3, n_3));

        double x_4 = 0.44528;
        int n_4 = 0;
        double expect_4 = 1;
        AssertUtils.assertEqualsDouble(expect_4, solution.myPow(x_4, n_4));

        double x_5 = 1.00000;
        int n_5 = -2147483648;
        double expect_5 = 1;
        AssertUtils.assertEqualsDouble(expect_5, solution.myPow(x_5, n_5));

        double x_6 = 2.00000;
        int n_6 = -2147483648;
        double expect_6 = 0;
        AssertUtils.assertEqualsDouble(expect_6, solution.myPow(x_6, n_6));

        double x_7 = 8.95371;
        int n_7 = -1;
        double expect_7 = 1/8.95371;
        AssertUtils.assertEqualsDouble(expect_7, solution.myPow(x_7, n_7));
    }
}
