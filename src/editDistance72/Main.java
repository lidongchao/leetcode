package editDistance72;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String word1_1 = "horse";
        String word2_1 = "ros";
        int expect_1 = 3;
        AssertUtils.assertEqualsInteger(expect_1, solution.minDistance(word1_1, word2_1));

        String word1_2 = "intention";
        String word2_2 = "execution";
        int expect_2 = 5;
        AssertUtils.assertEqualsInteger(expect_2, solution.minDistance(word1_2, word2_2));

        String word1_3 = "";
        String word2_3 = "horse";
        int expect_3 = 5;
        AssertUtils.assertEqualsInteger(expect_3, solution.minDistance(word1_3, word2_3));
    }
}
