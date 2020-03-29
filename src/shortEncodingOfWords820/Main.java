package shortEncodingOfWords820;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution4 solution = new Solution4();

        String[] words_1 = {"time", "me", "bell"};
        int expect_1 = 10;  // time#bell#
        AssertUtils.assertEqualsInteger(expect_1, solution.minimumLengthEncoding(words_1));

        String[] words_2 = {"time", "time", "time"};
        int expect_2 = 5;  // time#
        AssertUtils.assertEqualsInteger(expect_2, solution.minimumLengthEncoding(words_2));

        String[] words_3 = {"time", "datetime", "time"};
        int expect_3 = 9;  // datetime#
        AssertUtils.assertEqualsInteger(expect_3, solution.minimumLengthEncoding(words_3));
    }
}
