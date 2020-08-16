package recoverBinarySearchTree99;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路 1：中序遍历 + 排序
 *
 * 二叉搜索树的中序遍历是单调递增的
 *
 * 执行用时：4 ms, 在所有 Java 提交中击败了31.16%的用户
 * 内存消耗：39.6 MB, 在所有 Java 提交中击败了98.52%的用户
 */
class Solution1 {
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
        // 对 list 排序，只交换节点的值，不交换节点的地址
        sort(list, 0, list.size() - 1);
    }

    // 中序遍历
    private void visitList(List<TreeNode> list, TreeNode node) {
        if (node == null) return;
        visitList(list, node.left);
        list.add(node);
        visitList(list, node.right);
    }

    // 归并排序
    private void sort(List<TreeNode> list, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        sort(list, start, mid);
        sort(list, mid+1, end);
        mergeSort(list, start, mid, end);
    }

    private void mergeSort(List<TreeNode> list, int start, int mid, int end) {
        // 使用一个数组保存排序后的节点的值
        int[] sorted = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (list.get(i).val <= list.get(j).val) {
                sorted[k++] = list.get(i).val;
                i++;
            } else {
                sorted[k++] = list.get(j).val;
                j++;
            }
        }
        while (i <= mid) {
            sorted[k++] = list.get(i).val;
            i++;
        }
        while (j <= end) {
            sorted[k++] = list.get(j).val;
            j++;
        }
        // 只交换节点的值，不交换节点的地址
        for (int l = start; l <= end; l++) {
            list.get(l).val = sorted[l - start];
        }
    }
}
