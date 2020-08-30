package addStrings415;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "123";
        String s2 = "45678";
        String expect = "45801";
        AssertUtils.assertEquals(expect, solution.addStrings(s1, s2));
    }
}
