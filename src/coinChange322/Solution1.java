package coinChange322;

import java.util.Arrays;

/**
 * 思路2：递归实现贪心法+回溯
 *
 * 执行用时 :5 ms, 在所有 Java 提交中击败了96.98%的用户
 * 内存消耗 :37.5 MB, 在所有 Java 提交中击败了5.01%的用户
 */
class Solution1 {
    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
     * 如果没有任何一种硬币组合能组成总金额，返回 -1。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/coin-change
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param coins 硬币种类组成的列表
     * @param amount 总金额
     * @return 硬币个数
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        // 排序保证算法正确性
        Arrays.sort(coins);
        // 初始化返回值为极大值
        res = Integer.MAX_VALUE;
        // 兑换零钱，从面值最大的零钱开始 (贪心)
        change(coins, amount, coins.length-1, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * 使用当前指定的某一种零钱兑换出需要的金额
     * @param coins 所有零钱的种类
     * @param amount 需要兑换的金额
     * @param index 当前零钱的下标
     * @param count 已兑换的零钱的数量
     */
    private void change(int[] coins, int amount, int index, int count) {
        // 金额已经满足要求，无需继续兑换，记录所需要的零钱数量
        if (amount == 0) {
            res = Math.min(res, count);
            return;
        }
        // 已经没有更小的零钱可以兑换了，此路不通，直接返回
        if (index == -1) {
            return;
        }
        // 使用当前指定的一种零钱进行兑换，先使用最大的量 (贪心)，然后将剩余的金额交给比自己面值小一点的零钱；
        // 接着再尝试逐渐减少当前零钱的使用数量，看看是否有其他更优的解 (回溯)
        for (int n = amount / coins[index]; n >= 0 ; n--) {
            // 剪枝：检查是否已经超过最优解，没有的话才能继续兑换
            if (count+n < res) {
                change(coins, amount - n * coins[index], index - 1, count + n);
            }
        }
    }

    private int res;
}
