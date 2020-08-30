package generateParentheses22;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n_1 = 3;
        int expect_1 = 5;
        AssertUtils.assertEquals(expect_1, solution.generateParenthesis(n_1).size());
    }
}
