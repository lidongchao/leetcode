package implementStrstr28;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution4 solution = new Solution4();

        {
            String haystack = "hello";
            String needle = "ll";
            int expect = 2;
            AssertUtils.assertEquals(expect, solution.strStr(haystack, needle));
        }

        {
            String haystack = "aabaaabaaac";
            String needle = "aabaaac";
            int expect = 4;
             AssertUtils.assertEquals(expect, solution.strStr(haystack, needle));
        }

        {
            String haystack = "aaaaa";
            String needle = "bba";
            int expect = -1;
            AssertUtils.assertEquals(expect, solution.strStr(haystack, needle));
        }

        {
            String haystack = "mississippi";
            String needle = "pi";
            int expect = 9;
            AssertUtils.assertEquals(expect, solution.strStr(haystack, needle));
        }

        {
            String haystack = "babbbbbabb";
            String needle = "bbab";
            int expect = 5;
            AssertUtils.assertEquals(expect, solution.strStr(haystack, needle));
        }
    }
}
