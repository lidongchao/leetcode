package translateNumLcof_46;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        int num_1 = 12258;
        int expect_1 = 5;
        AssertUtils.assertEqualsInteger(expect_1, solution.translateNum(num_1));

        int num_2 = 26;
        int expect_2 = 1;
        AssertUtils.assertEqualsInteger(expect_2, solution.translateNum(num_2));

        int num_3 = 25;
        int expect_3 = 2;
        AssertUtils.assertEqualsInteger(expect_3, solution.translateNum(num_3));

        int num_4 = 506;
        int expect_4 = 1;
        AssertUtils.assertEqualsInteger(expect_4, solution.translateNum(num_4));
    }
}
