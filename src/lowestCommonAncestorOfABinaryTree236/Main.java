package lowestCommonAncestorOfABinaryTree236;

import utils.AssertUtils;
import utils.TreeNode;
import utils.TreeUtils;

public class Main {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();

        TreeNode root_1 = TreeUtils.construct(new Integer[]{3,5,1,6,2,0,8, null,null,7,4});
        TreeNode p_1 = TreeUtils.find(root_1, 5);
        TreeNode q_1 = TreeUtils.find(root_1, 1);
        int expect_1 = 3;
        AssertUtils.assertEqualsInteger(expect_1, solution.lowestCommonAncestor(root_1, p_1, q_1).val);

        TreeNode root_2 = TreeUtils.construct(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        TreeNode p_2 = TreeUtils.find(root_2, 5);
        TreeNode q_2 = TreeUtils.find(root_2, 4);
        int expect_2 = 5;
        AssertUtils.assertEqualsInteger(expect_2, solution.lowestCommonAncestor(root_2, p_2, q_2).val);
    }
}
