package atoi8;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        String s_1 = "42";
        int expect_1 = 42;
        AssertUtils.assertEquals(expect_1, solution.myAtoi(s_1));

        String s_2 = "   -42";
        int expect_2 = -42;
        AssertUtils.assertEquals(expect_2, solution.myAtoi(s_2));

        String s_3 = "4193 with words";
        int expect_3 = 4193;
        AssertUtils.assertEquals(expect_3, solution.myAtoi(s_3));

        String s_4 = "words and 987";
        int expect_4 = 0;
        AssertUtils.assertEquals(expect_4, solution.myAtoi(s_4));

        String s_5 = "-91283472332";
        int expect_5 = Integer.MIN_VALUE;
        AssertUtils.assertEquals(expect_5, solution.myAtoi(s_5));

        String s_6 = "0-1";
        int expect_6 = 0;
        AssertUtils.assertEquals(expect_6, solution.myAtoi(s_6));

    }
}
