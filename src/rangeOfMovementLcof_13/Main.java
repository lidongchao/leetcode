package rangeOfMovementLcof_13;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        int m_1 = 2;
        int n_1 = 3;
        int k_1 = 1;
        int expect_1 = 3;
        AssertUtils.assertEquals(expect_1, solution.movingCount(m_1, n_1, k_1));

        int m_2 = 3;
        int n_2 = 1;
        int k_2 = 0;
        int expect_2 = 1;
        AssertUtils.assertEquals(expect_2, solution.movingCount(m_2, n_2, k_2));

        int m_3 = 16;
        int n_3 = 8;
        int k_3 = 4;
        int expect_3 = 15;
        AssertUtils.assertEquals(expect_3, solution.movingCount(m_3, n_3, k_3));

        int m_4 = 38;
        int n_4 = 15;
        int k_4 = 9;
        int expect_4 = 135;
        AssertUtils.assertEquals(expect_4, solution.movingCount(m_4, n_4, k_4));

        int m_5 = 3;
        int n_5 = 2;
        int k_5 = 17;
        int expect_5 = 6;
        AssertUtils.assertEquals(expect_5, solution.movingCount(m_5, n_5, k_5));

    }
}
