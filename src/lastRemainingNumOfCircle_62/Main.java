package lastRemainingNumOfCircle_62;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int n_1 = 5;
        int m_1 = 3;
        int expect_1 = 3;
        AssertUtils.assertEqualsInteger(expect_1, solution.lastRemaining(n_1, m_1));

        int n_2 = 10;
        int m_2 = 17;
        int expect_2 = 2;
        AssertUtils.assertEqualsInteger(expect_2, solution.lastRemaining(n_2, m_2));

    }
}
