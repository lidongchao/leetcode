package superEggDrop887;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int K_1 = 1;
        int N_1 = 2;
        int expect_1 = 2;
        AssertUtils.assertEqualsInteger(expect_1, solution.superEggDrop(K_1, N_1));

        int K_2 = 2;
        int N_2 = 6;
        int expect_2 = 3;
        AssertUtils.assertEqualsInteger(expect_2, solution.superEggDrop(K_2, N_2));

        int K_3 = 3;
        int N_3 = 14;
        int expect_3 = 4;
        AssertUtils.assertEqualsInteger(expect_3, solution.superEggDrop(K_3, N_3));
    }
}
