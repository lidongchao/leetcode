package satisfiabilityOfEqualityEquations990;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] equations_1 = {"a==b","b!=a"};
        boolean expect_1 = false;
        AssertUtils.assertEqualsBoolean(expect_1, solution.equationsPossible(equations_1));

        String[] equations_2 = {"b==a","a==b"};
        boolean expect_2 = true;
        AssertUtils.assertEqualsBoolean(expect_2, solution.equationsPossible(equations_2));

        String[] equations_3 = {"a==b","b==c","a==c"};
        boolean expect_3 = true;
        AssertUtils.assertEqualsBoolean(expect_3, solution.equationsPossible(equations_3));

        String[] equations_4 = {"a==b","b!=c","c==a"};
        boolean expect_4 = false;
        AssertUtils.assertEqualsBoolean(expect_4, solution.equationsPossible(equations_4));

        String[] equations_5 = {"c==c","b==d","x!=z"};
        boolean expect_5 = true;
        AssertUtils.assertEqualsBoolean(expect_5, solution.equationsPossible(equations_5));

    }
}
