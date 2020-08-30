package twentyFourGame679;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        AssertUtils.assertEqualsBoolean(true, solution.judgePoint24(new int[]{4, 1, 8, 7}));
//        AssertUtils.assertEqualsBoolean(false, solution.judgePoint24(new int[]{1, 2, 1, 2}));
        AssertUtils.assertEquals(false, solution.judgePoint24(new int[]{3, 4, 6, 7}));
    }
}
