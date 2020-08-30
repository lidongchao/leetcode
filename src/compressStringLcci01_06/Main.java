package compressStringLcci01_06;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        String s_1 = "aabcccccaaa";
        String expect_1 = "a2b1c5a3";
        AssertUtils.assertEquals(expect_1, solution.compressString(s_1));

        String s_2 = "abbccd";
        String expect_2 = "abbccd";  // abbccd < a1b2c2d1
        AssertUtils.assertEquals(expect_2, solution.compressString(s_2));

    }
}
