package courseScheduleII210;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int numCourses_1 = 2;
        int[][] prerequisites_1 = {{1,0}};
        int[][] expect_1 = {{0,1}};
        AssertUtils.assertEqualsArrayAnyCase(expect_1, solution.findOrder(numCourses_1, prerequisites_1));

        int numCourses_2 = 4;
        int[][] prerequisites_2 = {{1,0},{2,0},{3,1},{3,2}};
        int[][] expect_2 = {{0,1,2,3},{0,2,1,3}};  // [0,1,2,3] or [0,2,1,3]
        AssertUtils.assertEqualsArrayAnyCase(expect_2, solution.findOrder(numCourses_2, prerequisites_2));

        int numCourses_3 = 1;
        int[][] prerequisites_3 = {};
        int[][] expect_3 = {{0}};
        AssertUtils.assertEqualsArrayAnyCase(expect_3, solution.findOrder(numCourses_3, prerequisites_3));

    }
}
