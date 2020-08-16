package restoreIpAddresses93;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s_1 = "25525511135";
        String[] expect_1 = {"255.255.11.135", "255.255.111.35"};
        AssertUtils.assertEqualsArrayIgnorePosition(expect_1, solution.restoreIpAddresses(s_1).toArray(new String[0]));

        String s_2 = "1111";
        String[] expect_2 = {"1.1.1.1"};
        AssertUtils.assertEqualsArrayIgnorePosition(expect_2, solution.restoreIpAddresses(s_2).toArray(new String[0]));
    }
}
