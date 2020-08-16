package houseRobberIII337;

import utils.TreeNode;

import java.util.HashMap;

/**
 * 思路 3：将记忆化存储在返回值中
 *
 * 执行用时：1 ms, 在所有 Java 提交中击败了74.25%的用户
 * 内存消耗：39.8 MB, 在所有 Java 提交中击败了6.88%的用户
 */
class Solution3 {
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
        int[] res = robLoop(root);

        return Math.max(res[0], res[1]);
    }

    private int[] robLoop(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        // 尝试打劫当前节点时，有两种方案：
        // res[0] 代表第一种，打劫当前节点；res[1] 代表第二种，不打劫当前节点
        int[] res = new int[2];

        int[] left = robLoop(node.left);
        int[] right = robLoop(node.right);
        // 第一种，打劫当前节点，就不能打劫两个子节点
        res[0] = node.val + left[1] + right[1];
        // 第二种，不打劫当前节点，那么可以尝试打劫两个子节点
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return res;
    }
}
