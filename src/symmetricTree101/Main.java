package symmetricTree101;

import utils.AssertUtils;
import utils.TreeUtils;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        Integer[] nodes = {1,2,2,3,4,4,3};
        AssertUtils.assertEqualsBoolean(true, solution.isSymmetric(TreeUtils.construct(nodes)));
    }
}
