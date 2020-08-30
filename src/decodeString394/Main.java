package decodeString394;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s_1 = "3[a]2[bc]";
        String expect_1 = "aaabcbc";
        AssertUtils.assertEquals(expect_1, solution.decodeString(s_1));

        String s_2 = "3[a2[c]]";
        String expect_2 = "accaccacc";
        AssertUtils.assertEquals(expect_2, solution.decodeString(s_2));

        String s_3 = "2[abc]3[cd]ef";
        String expect_3 = "abcabccdcdcdef";
        AssertUtils.assertEquals(expect_3, solution.decodeString(s_3));

        String s_4 = "100[leetcode]";
        String expect_4 = "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode";
        AssertUtils.assertEquals(expect_4, solution.decodeString(s_4));
    }
}
