package waterAndJugProblem365;

import utils.AssertUtils;

public class main {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();

        int x_1 = 3;
        int y_1 = 5;
        int z_1 = 4;
        boolean expect_1 = true;
        AssertUtils.assertEquals(expect_1, solution.canMeasureWater(x_1, y_1, z_1));

        int x_2 = 2;
        int y_2 = 6;
        int z_2 = 5;
        boolean expect_2 = false;
        AssertUtils.assertEquals(expect_2, solution.canMeasureWater(x_2, y_2, z_2));

        int x_3 = 22003;
        int y_3 = 31237;
        int z_3 = 1;
        boolean expect_3 = true;
        AssertUtils.assertEquals(expect_3, solution.canMeasureWater(x_3, y_3, z_3));

        int x_4 = 104659;
        int y_4 = 104677;
        int z_4 = 142424;
        boolean expect_4 = true;
        AssertUtils.assertEquals(expect_4, solution.canMeasureWater(x_4, y_4, z_4));


    }
}
