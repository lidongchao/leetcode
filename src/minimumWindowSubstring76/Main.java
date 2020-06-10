package minimumWindowSubstring76;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s_1 = "ADOBECODEBANC";
        String t_1 = "ABC";
        String expect_1 = "BANC";
        AssertUtils.assertEqualsString(expect_1, solution.minWindow(s_1, t_1));

        solution = new Solution();

        String s_2 = "AB";
        String t_2 = "B";
        String expect_2 = "B";
        AssertUtils.assertEqualsString(expect_2, solution.minWindow(s_2, t_2));

        solution = new Solution();

        String s_3 = "bba";
        String t_3 = "ab";
        String expect_3 = "ba";
        AssertUtils.assertEqualsString(expect_3, solution.minWindow(s_3, t_3));

        solution = new Solution();

        String s_4 = "abc";
        String t_4 = "d";
        String expect_4 = "";
        AssertUtils.assertEqualsString(expect_4, solution.minWindow(s_4, t_4));

    }
}
