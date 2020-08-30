package validParentheses20;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        AssertUtils.assertEquals(true, solution.isValid("()"));
        AssertUtils.assertEquals(true, solution.isValid("()[]{}"));
        AssertUtils.assertEquals(false, solution.isValid("(]"));
        AssertUtils.assertEquals(false, solution.isValid("([)]"));
        AssertUtils.assertEquals(true, solution.isValid("{[]}"));

    }
}
