package bestTimeToBuyAndSellStock121;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int[] prices_1 = {7,1,5,3,6,4};
        int expect_1 = 5;  // 6-1
        AssertUtils.assertEquals(expect_1, solution.maxProfit(prices_1));

        int[] prices_2 = {7,6,4,3,1};
        int expect_2 = 0;
        AssertUtils.assertEquals(expect_2, solution.maxProfit(prices_2));

        int[] prices_3 = {1,2};
        int expect_3 = 1;
        AssertUtils.assertEquals(expect_3, solution.maxProfit(prices_3));

        int[] prices_4 = {2,1,4};
        int expect_4 = 3;
        AssertUtils.assertEquals(expect_4, solution.maxProfit(prices_4));

        int[] prices_5 = {3,5,2,7};
        int expect_5 = 5;
        AssertUtils.assertEquals(expect_5, solution.maxProfit(prices_5));
    }
}
