package findInMountainArray1095;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] array_1 = {1,2,3,4,5,3,1};
        int target_1 = 3;
        int expect_1 = 2;
        AssertUtils.assertEqualsInteger(expect_1, solution.findInMountainArray(target_1, new MountainArray(array_1)));

        int[] array_2 = {0,1,2,4,2,1};
        int target_2 = 3;
        int expect_2 = -1;
        AssertUtils.assertEqualsInteger(expect_2, solution.findInMountainArray(target_2, new MountainArray(array_2)));

    }
}
