package validParentheses20;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        AssertUtils.assertEqualsBoolean(true, solution.isValid("()"));
        AssertUtils.assertEqualsBoolean(true, solution.isValid("()[]{}"));
        AssertUtils.assertEqualsBoolean(false, solution.isValid("(]"));
        AssertUtils.assertEqualsBoolean(false, solution.isValid("([)]"));
        AssertUtils.assertEqualsBoolean(true, solution.isValid("{[]}"));

    }
}
