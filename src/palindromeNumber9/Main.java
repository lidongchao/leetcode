package palindromeNumber9;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int x_1 = 121;
        AssertUtils.assertEqualsBoolean(true, solution.isPalindrome(x_1));

        int x_2 = -121;
        AssertUtils.assertEqualsBoolean(false, solution.isPalindrome(x_2));

        int x_3 = 10;
        AssertUtils.assertEqualsBoolean(false, solution.isPalindrome(x_3));
    }
}
