package jumpGame55;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int[] nums_1 = {2,3,1,1,4};
        boolean expect_1 = true;
        AssertUtils.assertEqualsBoolean(expect_1, solution.canJump(nums_1));

        int[] nums_2 = {3,2,1,0,4};
        boolean expect_2 = false;
        AssertUtils.assertEqualsBoolean(expect_2, solution.canJump(nums_2));

        int[] nums_3 = {8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
        boolean expect_3 = true;
        AssertUtils.assertEqualsBoolean(expect_3, solution.canJump(nums_3));




    }


}
