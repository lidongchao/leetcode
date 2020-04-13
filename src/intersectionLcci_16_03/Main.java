package intersectionLcci_16_03;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] start1_1 = {0, 0};
        int[] end1_1 = {1, 0};
        int[] start2_1 = {1, 1};
        int[] end2_1 = {0, -1};
        double[] expect_1 = {0.5, 0};
        AssertUtils.assertEqualsDoubleArray(expect_1, solution.intersection(start1_1, end1_1, start2_1, end2_1));

        int[] start1_2 = {0, 0};
        int[] end1_2 = {3, 3};
        int[] start2_2 = {1, 1};
        int[] end2_2 = {2, 2};
        double[] expect_2 = {1, 1};
        AssertUtils.assertEqualsDoubleArray(expect_2, solution.intersection(start1_2, end1_2, start2_2, end2_2));

        int[] start1_3 = {0, 0};
        int[] end1_3 = {1, 1};
        int[] start2_3 = {1, 0};
        int[] end2_3 = {2, 1};
        double[] expect_3 = {};
        AssertUtils.assertEqualsDoubleArray(expect_3, solution.intersection(start1_3, end1_3, start2_3, end2_3));

        int[] start1_4 = {0, 0};
        int[] end1_4 = {0, 1};
        int[] start2_4 = {0, 2};
        int[] end2_4 = {0, 3};
        double[] expect_4 = {};
        AssertUtils.assertEqualsDoubleArray(expect_4, solution.intersection(start1_4, end1_4, start2_4, end2_4));

    }
}
