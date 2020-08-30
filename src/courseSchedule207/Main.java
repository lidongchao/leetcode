package courseSchedule207;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        AssertUtils.assertEquals(true, solution.canFinish(2, new int[][]{{1,0}}));  // true
        AssertUtils.assertEquals(false, solution.canFinish(2, new int[][]{{1,0},{0,1}}));  // false
        AssertUtils.assertEquals(true, solution.canFinish(3, new int[][]{{2,0},{2,1}}));  // true
        AssertUtils.assertEquals(true, solution.canFinish(4, new int[][]{{1,0},{2,0},{3,1},{3,2}}));  // true
        AssertUtils.assertEquals(true, solution.canFinish(8, new int[][]{{1,0},{2,6},{1,7},{6,4},{7,0},{0,5}}));  // true
    }
}
