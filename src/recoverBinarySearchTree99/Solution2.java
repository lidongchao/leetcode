package recoverBinarySearchTree99;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路 2：中序遍历 + 寻找被错误交换的节点并交换
 *
 * 只有两个节点被错误地交换，没有必要排序
 *
 * 执行用时：3 ms, 在所有 Java 提交中击败了53.50%的用户
 * 内存消耗：40.4 MB, 在所有 Java 提交中击败了5.60%的用户
 */
class Solution2 {
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
        ArrayList<TreeNode> list = new ArrayList<>();
        // 中序遍历整个二叉树，将访问到的节点按顺序加入到 list 中
        visitList(list, root);
        recoverTree(list);
    }

    // 寻找被错误交换的节点并交换。
    private void recoverTree(ArrayList<TreeNode> list) {
        int i = -1;
        int j = -1;
        // 从 1 6 3 4 5 2 中发现 2 和 6 被错误交换，逆序对为 (6,3) 和 (5,2)
        // 从 1 2 4 3 5 6 中发现 3 和 4 被错误交换，逆序对为 (4,3)
        for (int k = 0; k < list.size() - 1; k++) {
            if (list.get(k).val > list.get(k + 1).val) {
                j = k + 1;
                if (i == -1) {
                    // 找到第一对相邻逆序节点
                    i = k;
                } else {
                    // 走到这个分支，说明找到了两对相邻逆序节点，交换节点分别是第一对逆序节点的前者，以及第二对逆序节点的后者。
                    // 否则只有一对相邻逆序节点，两个都是交换节点。
                    break;
                }
            }
        }
        int temp = list.get(i).val;
        list.get(i).val = list.get(j).val;
        list.get(j).val = temp;

    }

    // 中序遍历
    private void visitList(List<TreeNode> list, TreeNode node) {
        if (node == null) return;
        visitList(list, node.left);
        list.add(node);
        visitList(list, node.right);
    }
}
