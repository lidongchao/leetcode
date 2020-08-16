package houseRobberIII337;

import utils.TreeNode;

import java.util.HashMap;

/**
 * 思路 2：递归 + 记忆化
 *
 * 执行用时 :4 ms, 在所有 Java 提交中击败了38.67%的用户
 * 内存消耗 :39.3 MB, 在所有 Java 提交中击败了93.30%的用户
 */
class Solution2 {
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
        map.clear();
        return robInternal(root);
    }

    private int robInternal(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 如果有计算过，则不需要重复计算
        if (map.containsKey(node.hashCode())) {
            return map.get(node.hashCode());
        }

        // 尝试打劫当前节点时，有两种方案：
        // 第一种，打劫当前节点，就不能打劫两个子节点，但是能够尝试打劫四个孙节点
        int robRoot = node.val;
        if (node.left != null) {
            robRoot += rob(node.left.left) + rob(node.left.right);
        }
        if (node.right != null) {
            robRoot += rob(node.right.left) + rob(node.right.right);
        }
        // 第二种，不打劫当前节点，那么可以尝试打劫两个子节点
        int robSon = rob(node.left) + rob(node.right);
        // 查看两种方案哪一种收益最大，存储计算结果
        int max = Math.max(robRoot, robSon);
        map.put(node.hashCode(), max);
        return max;
    }

    public Solution2() {
        map = new HashMap<>();
    }

    private final HashMap<Integer, Integer> map;
}
