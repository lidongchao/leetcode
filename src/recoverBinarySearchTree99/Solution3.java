package recoverBinarySearchTree99;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路 3：中序遍历 + 寻找被错误交换的节点并交换
 *
 * 执行用时：2 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：39.9 MB, 在所有 Java 提交中击败了87.02%的用户
 */
class Solution3 {
    /**
     * 二叉搜索树中的两个节点被错误地交换。
     * 请在不改变其结构的情况下，恢复这棵树。
     *
     * 示例 1:
     * 输入: [1,3,null,null,2]
     *    1
     *   /
     *  3
     *   \
     *    2
     * 输出: [3,1,null,null,2]
     *    3
     *   /
     *  1
     *   \
     *    2
     *
     * 示例 2:
     * 输入: [3,1,4,null,null,2]
     *   3
     *  / \
     * 1   4
     *    /
     *   2
     * 输出: [2,1,4,null,null,3]
     *   2
     *  / \
     * 1   4
     *    /
     *   3
     *
     * 进阶:
     * 使用 O(n) 空间复杂度的解法很容易实现。
     * 你能想出一个只使用常数空间的解决方案吗？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root 二叉树的根节点
     */
    public void recoverTree(TreeNode root) {
        // 中序遍历整个二叉树，将访问到的节点按顺序加入到 list 中
        visitList(root, null);
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    // 中序遍历
    private TreeNode visitList(TreeNode node, TreeNode rootsParent) {
        if (node == null) return null;
        // left
        TreeNode left = visitList(node.left, rootsParent);
        // current
        TreeNode prev = null;
        if (left != null) {
            prev = left;
        } else if (rootsParent != null) {
            prev = rootsParent;
        }
        if (prev != null) {
            // 找到一对相邻逆序节点
            if (prev.val > node.val) {
                node2 = node;
                if (node1 == null) {
                    node1 = prev;
                } else {
                    // 已经找到两对相邻逆序节点，快速退出
                    return null;
                }
            }
        }
        // right
        TreeNode right = visitList(node.right, node);

        return right == null ? node : right;
    }

    private TreeNode node1 = null;
    private TreeNode node2 = null;
}
