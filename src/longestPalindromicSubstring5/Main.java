package longestPalindromicSubstring5;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        String s_1 = "babad";
        String expect_1 = "bab";
        AssertUtils.assertEqualsString(expect_1, solution.longestPalindrome(s_1));

        String s_2 = "cbbd";
        String expect_2 = "bb";
        AssertUtils.assertEqualsString(expect_2, solution.longestPalindrome(s_2));

        String s_3 = "ac";
        String expect_3 = "a";
        AssertUtils.assertEqualsString(expect_3, solution.longestPalindrome(s_3));

        String s_4 = "bb";
        String expect_4 = "bb";
        AssertUtils.assertEqualsString(expect_4, solution.longestPalindrome(s_4));

    }
}
