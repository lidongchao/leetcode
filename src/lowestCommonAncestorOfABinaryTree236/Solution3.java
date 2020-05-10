package lowestCommonAncestorOfABinaryTree236;

import utils.TreeNode;

/**
 * 思路 3：递归/DFS
 *
 * 两个节点 p、q 的最近公共祖先 ca，具有以下的特征：
 *
 * 1. ca 的左子树能找到 p，右子树能找到 q. (left && right)
 * 2. ca 的左子树能找到 q，右子树能找到 p. (left && right)
 * 3. ca 等于 p，在左子树或右子树中找到了 q. (node == p) && (left || right)
 * 4. ca 等于 q，在左子树或右子树中找到了 p. (node == q) && (left || right)
 *
 * 而 ca 的父节点 (假设存在)，则不满足以上的特征，只会在左子树或右子树中同时找到 p 和 q。
 *
 * 执行用时 :8 ms, 在所有 Java 提交中击败了86.08%的用户
 * 内存消耗 :41.7 MB, 在所有 Java 提交中击败了5.71%的用户
 */
class Solution3 {
    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root 二叉树的根节点
     * @param p 指定节点1
     * @param q 指定节点2
     * @return 最近公共祖先节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    // 只要以 node 为根节点的二叉树中存在 p 或者 q，就返回 true。
    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;

        boolean left = dfs(node.left, p, q);
        boolean right = dfs(node.right, p, q);

        // 以下情况均能证明 node 一定是 p q 的最近公共祖先
        // 1. node 节点的左子树能找到 p，右子树能找到 q. (left && right)
        // 2. node 节点的左子树能找到 q，右子树能找到 p. (left && right)
        // 3. node 节点为 p，在左子树或右子树中找到了 q. (node == p) && (left || right)
        // 4. node 节点为 q，在左子树或右子树中找到了 p. (node == q) && (left || right)
        if ( (left && right) || ((node == p || node == q) && (left || right)) ) {
            ans = node;
        }

        return left || right || node == p || node == q;
    }

    private TreeNode ans = null;
}
