package partitionArrayIntoThreeEqualParts1013;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int[] A_1 = {0,2,1,-6,6,-7,9,1,2,0,1};  // 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
        boolean expect_1 = true;
        AssertUtils.assertEquals(expect_1, solution.canThreePartsEqualSum(A_1));

        int[] A_2 = {0,2,1,-6,6,7,9,-1,2,0,1};
        boolean expect_2 = false;
        AssertUtils.assertEquals(expect_2, solution.canThreePartsEqualSum(A_2));

        int[] A_3 = {3,3,6,5,-2,2,5,1,-9,4};
        boolean expect_3 = true;
        AssertUtils.assertEquals(expect_3, solution.canThreePartsEqualSum(A_3));


    }
}
