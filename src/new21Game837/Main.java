package new21Game837;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int         N_1 = 10;
        int         K_1 = 1;
        int         W_1 = 10;
        double expect_1 = 1.0;
        AssertUtils.assertEqualsDouble(
                expect_1,
                solution.new21Game(
                        N_1,
                        K_1,
                        W_1
                )
        );

        int         N_2 = 6;
        int         K_2 = 1;
        int         W_2 = 10;
        double expect_2 = 0.6;
        AssertUtils.assertEqualsDouble(
                expect_2,
                solution.new21Game(
                        N_2,
                        K_2,
                        W_2
                )
        );

        int         N_3 = 10;
        int         K_3 = 1;
        int         W_3 = 10;
        double expect_3 = 1.0;
        AssertUtils.assertEqualsDouble(
                expect_3,
                solution.new21Game(
                        N_3,
                        K_3,
                        W_3
                )
        );
    }
}
