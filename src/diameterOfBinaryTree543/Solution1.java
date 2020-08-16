package diameterOfBinaryTree543;

import utils.TreeNode;

/**
 * 思路 1：DFS 深度优先遍历
 *
 * 计算直径需要找到二叉树中最远的两个结点，这两个结点到最近的共同祖先所经过的路径之和，就是直径长度。
 *
 * 那么以这个共同祖先作为根结点的子树，其左子树的深度 + 右子树的深度，也可以得到直径长度。
 *
 * (这里将树的深度等定义为从根结点到叶子结点的最长简单路径的结点的个数，只有一个结点的二叉树，其深度为 1)
 *
 * 因此变成了求每一个子树的左子树深度和右子树深度之和，并求最大值，这个过程可以通过深度优先遍历算法实现。
 *
 * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :39.6 MB, 在所有 Java 提交中击败了5.08%的用户
 */
class Solution1 {
    /**
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree/
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root 树的根结点
     * @return 树的直径
     */
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return dOfTree;
    }

    private int dfs(TreeNode root) {
        if (null == root) return 0;
        // 左子树深度
        int leftDepth = dfs(root.left);
        // 右子树深度
        int rightDepth = dfs(root.right);
        // 计算出树的直径
        dOfTree = Math.max(leftDepth + rightDepth, dOfTree);
        // 向上返回当前结点的深度
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // 树的直径
    private int dOfTree = 0;
}