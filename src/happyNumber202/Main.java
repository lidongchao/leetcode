package happyNumber202;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 19;
        boolean expect = true;
        AssertUtils.assertEqualsBoolean(expect, solution.isHappy(n));

    }
}
