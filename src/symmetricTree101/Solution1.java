package symmetricTree101;

import utils.TreeNode;
import java.util.LinkedList;

/**
 * 思路 1：递归
 *
 * 执行用时 :1 ms, 在所有 Java 提交中击败了37.93%的用户
 * 内存消耗 :39.4 MB, 在所有 Java 提交中击败了5.00%的用户
 */
class Solution1 {
    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     *
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     *  
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *
     *    1
     *   / \
     *  2   2
     *   \   \
     *   3    3
     *  
     * 进阶：
     *
     * 你可以运用递归和迭代两种方法解决这个问题吗？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/symmetric-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root 二叉树根节点
     * @return 是否是镜像对称的
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null) {
            return root.right == null;
        }
        if (root.right == null) {
            return false;
        }

        LinkedList<TreeNode> list = new LinkedList<>();

        list.add(root.left);
        list.add(root.right);

        // 镜像操作
        while (!list.isEmpty()) {
            TreeNode nodeLeft = list.pollFirst();
            TreeNode nodeRight = list.pollLast();

            if (nodeLeft == null && nodeRight == null) continue;
            if (nodeLeft == null || nodeRight == null || nodeLeft.val != nodeRight.val) return false;

            list.addFirst(nodeLeft.left);
            list.addLast(nodeRight.right);

            list.addFirst(nodeLeft.right);
            list.addLast(nodeRight.left);
        }

        return true;
    }
}
