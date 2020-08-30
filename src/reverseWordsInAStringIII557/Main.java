package reverseWordsInAStringIII557;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String word = "Let's take LeetCode contest";
        String expect = "s'teL ekat edoCteeL tsetnoc";
        AssertUtils.assertEquals(expect, solution.reverseWords(word));

    }
}
