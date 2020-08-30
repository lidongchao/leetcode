package longestCommonPrefix14;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        String[] strs_1 = {"flower","flow","flight"};
        String expect_1 = "fl";
        AssertUtils.assertEquals(expect_1, solution.longestCommonPrefix(strs_1));

        String[] strs_2 = {"dog","racecar","car"};
        String expect_2 = "";
        AssertUtils.assertEquals(expect_2, solution.longestCommonPrefix(strs_2));
    }
}
