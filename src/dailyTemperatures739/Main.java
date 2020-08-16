package dailyTemperatures739;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();

        int[] T_1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] expect_1 = {1, 1, 4, 2, 1, 1, 0, 0};
        AssertUtils.assertEqualsIntArray(expect_1, solution.dailyTemperatures(T_1));
    }
}
