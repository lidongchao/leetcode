package houseRobberIII337;

import utils.AssertUtils;
import utils.GeneratorUtils;
import utils.TreeNode;

public class Main {
    public static void main(String[] args) {

        AssertUtils.mute();
        for (int i = 0; i < 10000; i++) {
            Solution1 solution1 = new Solution1();
            Solution2 solution2 = new Solution2();
            Solution3 solution3 = new Solution3();
            TreeNode tree = GeneratorUtils.generateTree(10, 80, 0, 10);

//            if (!AssertUtils.assertEqualsInteger(solution1.rob(tree), solution2.rob(tree))) {
//                assert tree != null;
//                System.out.println(tree.serialize());
//            }
            if (!AssertUtils.assertEqualsInteger(solution2.rob(tree), solution3.rob(tree))) {
                assert tree != null;
                System.out.println(tree.serialize());
            }
        }

    }
}
