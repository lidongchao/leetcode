package repeatedSubstringPattern459;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        AssertUtils.assertEquals(true, solution1.repeatedSubstringPattern("abab"));
        AssertUtils.assertEquals(false, solution1.repeatedSubstringPattern("aba"));
        AssertUtils.assertEquals(true, solution1.repeatedSubstringPattern("abcabcabcabc"));

        Solution2 solution2 = new Solution2();
        AssertUtils.assertEquals(true, solution2.repeatedSubstringPattern("abab"));
        AssertUtils.assertEquals(false, solution2.repeatedSubstringPattern("aba"));
        AssertUtils.assertEquals(true, solution2.repeatedSubstringPattern("abcabcabcabc"));
    }
}
