package coinLcci_08_11;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int n_1 = 5;
        int expect_1 = 2;
        AssertUtils.assertEquals(expect_1, solution.waysToChange(n_1));

        int n_2 = 10;
        int expect_2 = 4;
        AssertUtils.assertEquals(expect_2, solution.waysToChange(n_2));

        int n_3 = 900750;
        int expect_3 = 504188296;
        AssertUtils.assertEquals(expect_3, solution.waysToChange(n_3));

    }
}
