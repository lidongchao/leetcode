package validPalindromeII680;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s_1 = "aba";
        boolean expect_1 = true;
        AssertUtils.assertEqualsBoolean(expect_1, solution.validPalindrome(s_1));

        String s_2 = "abca";
        boolean expect_2 = true;
        AssertUtils.assertEqualsBoolean(expect_2, solution.validPalindrome(s_2));


    }
}
