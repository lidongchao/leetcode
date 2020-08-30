package mergeIntervals56;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] intervals_1 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] expect_1 = {{1,6},{8,10},{15,18}};
        AssertUtils.assertEquals2DArray(expect_1, solution.merge(intervals_1));

        int[][] intervals_2 = {{1,4},{4,5}};
        int[][] expect_2 = {{1,5}};
        AssertUtils.assertEquals2DArray(expect_2, solution.merge(intervals_2));
    }
}
