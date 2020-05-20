package findTheLongestSubstringContainingVowelsInEvenCounts1371;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        String s_1 = "eleetminicoworoep";
        int expect_1 = 13;  // "leetminicowor"
        AssertUtils.assertEqualsInteger(expect_1, solution.findTheLongestSubstring(s_1));

        String s_2 = "leetcodeisgreat";
        int expect_2 = 5;  // "leetc"
        AssertUtils.assertEqualsInteger(expect_2, solution.findTheLongestSubstring(s_2));

        String s_3 = "bcbcbc";
        int expect_3 = 6;  // "bcbcbc"
        AssertUtils.assertEqualsInteger(expect_3, solution.findTheLongestSubstring(s_3));
    }
}
