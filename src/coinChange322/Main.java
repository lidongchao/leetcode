package coinChange322;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        int[] coins_1 = {1,2,5};
        int amount_1 = 11;
        int expect_1 = 3;  // 5+5+1
        AssertUtils.assertEqualsInteger(expect_1, solution.coinChange(coins_1, amount_1));

        int[] coins_2 = {2};
        int amount_2 = 3;
        int expect_2 = -1;
        AssertUtils.assertEqualsInteger(expect_2, solution.coinChange(coins_2, amount_2));

        int[] coins_3 = {1};
        int amount_3 = 1;
        int expect_3 = 1;
        AssertUtils.assertEqualsInteger(expect_3, solution.coinChange(coins_3, amount_3));

        int[] coins_4 = {10,7,1};
        int amount_4 = 14;
        int expect_4 = 2;
        AssertUtils.assertEqualsInteger(expect_4, solution.coinChange(coins_4, amount_4));

        int[] coins_5 = {186,419,83,408};
        int amount_5 = 6249;
        int expect_5 = 20;
        AssertUtils.assertEqualsInteger(expect_5, solution.coinChange(coins_5, amount_5));

        int[] coins_6 = {3,7,405,436};
        int amount_6 = 8839;
        int expect_6 = 25;
        AssertUtils.assertEqualsInteger(expect_6, solution.coinChange(coins_6, amount_6));
    }
}
