package countTheRepetitions466;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        String  s1_1 = "abc";
//        int     n1_1 = 4;
//        String  s2_1 = "ab";
//        int     n2_1 = 2;
//        int expect_1 = 2;
//        AssertUtils.assertEqualsInteger(expect_1,
//                solution.getMaxRepetitions( s1_1,
//                                            n1_1,
//                                            s2_1,
//                                            n2_1));

        String  s1_2 = "bacaba";
        int     n1_2 = 3;
        String  s2_2 = "abacab";
        int     n2_2 = 1;
        int expect_2 = 0;
        AssertUtils.assertEqualsInteger(expect_2,
                solution.getMaxRepetitions( s1_2,
                                            n1_2,
                                            s2_2,
                                            n2_2));
    }
}
