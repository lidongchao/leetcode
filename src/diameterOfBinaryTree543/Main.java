package diameterOfBinaryTree543;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        TreeNode root_1 = new TreeNode(1);
        root_1.left = new TreeNode(2);
        root_1.right = new TreeNode(3);
        root_1.left.left = new TreeNode(4);
        root_1.left.right = new TreeNode(5);
        int expect_1 = 3;
        AssertUtils.assertEqualsInteger(expect_1, solution.diameterOfBinaryTree(root_1));

    }
}
