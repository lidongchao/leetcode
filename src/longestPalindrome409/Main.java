package longestPalindrome409;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        String s_1 = "abccccdd";
        int expect_1 = 7;  // len("dccaccd") = 7
        AssertUtils.assertEquals(expect_1, solution.longestPalindrome(s_1));
    }
}
