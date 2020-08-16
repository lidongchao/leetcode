package constructBinaryTreeFromPreorderAndInorderTraversal105;

import utils.AssertUtils;
import utils.TreeNode;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        //   3
        //  / \
        // 9  20
        //   /  \
        //  15   7
        TreeNode root = solution.buildTree(preorder, inorder);
        AssertUtils.assertEqualsInteger(3, root.val);
        AssertUtils.assertEqualsInteger(9, root.left.val);
        AssertUtils.assertEqualsInteger(20, root.right.val);
        AssertUtils.assertEqualsInteger(15, root.right.left.val);
        AssertUtils.assertEqualsInteger(7, root.right.right.val);

    }
}
