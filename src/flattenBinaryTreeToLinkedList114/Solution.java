package flattenBinaryTreeToLinkedList114;

import utils.TreeNode;

/**
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：39.7 MB, 在所有 Java 提交中击败了12.57%的用户
 */
class Solution {
    /**
     * 给定一个二叉树，原地将它展开为一个单链表。
     *
     * 例如，给定二叉树
     *
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     * 将其展开为：
     *
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     *        \
     *         5
     *          \
     *           6
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root 二叉树根节点
     */
    public void flatten(TreeNode root) {
        flattenNode(root);
    }

    /**
     * 将根为 node 的二叉树展开成一个单链表，返回链表末尾的节点。
     * @param node 二叉树根节点
     * @return 展开变成的链表的尾节点
     */
    private TreeNode flattenNode(TreeNode node) {
        // 空树
        if (node == null) {
            return null;
        }

        // 预先得到两棵子树，避免丢失
        TreeNode left = node.left;
        TreeNode right = node.right;

        // 如果左子树不为空，则将左子树展开成一个单链表，将左子树的根节点 left 拼接在 node.right 处，同时会返回展开后的链表末尾的节点 flattenLeftEnd，
        // 再将右子树展开成一个单链表，将右子树的根节点 right 拼接在 flattenLeftEnd.right 处。不要忘了将 node.left 置为空。
        // 形成 node <- left <- flattenLeftEnd [<- right <- flattenRightEnd]
        if (left != null) {
            TreeNode flattenLeftEnd = flattenNode(left);
            TreeNode flattenRightEnd = flattenNode(right);
            node.right = left;
            flattenLeftEnd.right = right;
            node.left = null;
            return flattenRightEnd != null ? flattenRightEnd : flattenLeftEnd;  // 返回整个链表末尾的节点
        }
        // 左子树为空，右子树不为空，只需要继续处理右子树。
        if (right != null) {
            return flattenNode(right);
        }

        // 叶子节点，返回该节点
        return node;
    }
}
