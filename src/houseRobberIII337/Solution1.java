package houseRobberIII337;

import utils.TreeNode;

/**
 * 思路 1：递归
 *
 * 执行用时 :895 ms, 在所有 Java 提交中击败了18.79%的用户
 * 内存消耗 :39.7 MB, 在所有 Java 提交中击败了28.92%的用户
 */
class Solution1 {
    /**
     * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
     * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
     * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
     *
     * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root 根节点
     * @return 在不触动警报的情况下一晚能够盗取的最高金额
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 尝试打劫当前节点时，有两种方案：
        // 第一种，打劫当前节点，就不能打劫两个子节点，但是能够尝试打劫四个孙节点
        int robRoot = root.val;
        if (root.left != null) {
            robRoot += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            robRoot += rob(root.right.left) + rob(root.right.right);
        }
        // 第二种，不打劫当前节点，那么可以尝试打劫两个子节点
        int robSon = rob(root.left) + rob(root.right);
        // 查看两种方案哪一种收益最大
        return Math.max(robRoot, robSon);
    }
}
