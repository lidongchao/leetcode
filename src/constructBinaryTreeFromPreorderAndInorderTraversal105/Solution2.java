package constructBinaryTreeFromPreorderAndInorderTraversal105;

import utils.TreeNode;

/**
 * 思路 2：递归
 *
 * [3,9,20,15,7]
 * [9,3,15,20,7]
 *
 * pre=0 in=0 stop=-2147483648          -> node(3)
 *   l--> pre=1 in=0 stop=3             -> node[9]
 *   r--> pre=2 in=2 stop=-2147483648   -> node[20]
 *     l--> pre=3 in=2 stop=20          -> node[15]
 *     r--> pre=4 in=4 stop=-2147483648 -> node[7]
 *
 */
class Solution2 {
    /**
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     *
     * 注意:
     * 你可以假设树中没有重复的元素。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param preorder 一棵树的前序遍历
     * @param inorder  一棵树的中序遍历
     * @return 这棵树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, Integer.MIN_VALUE);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, long stop) {
        //数组为空则返回null
        if (pre == preorder.length) {
            return null;
        }
        //中序遍历序列数组顺序值等于终止值，则依次后移
        //表示此节点为空
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        //按照先序遍历顺序值新建节点
        int val = preorder[pre++];
        TreeNode root = new TreeNode(val);
        //建立左节点，终止值为当前节点值
        root.left = buildTree(preorder, inorder, val);
        //建立右节点，终止值为上一节点值
        root.right = buildTree(preorder, inorder, stop);
        //返回当前节点
        return root;
    }

    private int pre = 0;
    private int in = 0;
}
