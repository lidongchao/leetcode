package reverseWordsInAString151;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        String s_1 = "the sky is blue";
        String expect_1 = "blue is sky the";
        AssertUtils.assertEquals(expect_1, solution.reverseWords(s_1));

        String s_2 = "  hello world!  ";
        String expect_2 = "world! hello";
        AssertUtils.assertEquals(expect_2, solution.reverseWords(s_2));

        String s_3 = "a good   example";
        String expect_3 = "example good a";
        AssertUtils.assertEquals(expect_3, solution.reverseWords(s_3));
    }
}
