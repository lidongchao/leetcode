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
        AssertUtils.assertEquals(3, root.val);
        AssertUtils.assertEquals(9, root.left.val);
        AssertUtils.assertEquals(20, root.right.val);
        AssertUtils.assertEquals(15, root.right.left.val);
        AssertUtils.assertEquals(7, root.right.right.val);

    }
}
