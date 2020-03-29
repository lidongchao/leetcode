package bestTimeToBuyAndSellStock121;

/**
 * 思路 2：不再维护数组，而是从第一天开始遍历，只维护从第一天到当天的最低价，然后判断以最低价买入，当天价格卖出得到的利润是不是更大
 *
 * 执行用时 :1 ms, 在所有 Java 提交中击败了99.57%的用户
 * 内存消耗 :42.9 MB, 在所有 Java 提交中击败了5.02%的用户
 */
public class Solution2 {
    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     *
     * 注意你不能在买入股票前卖出股票。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param prices 价格随时间变化的数组
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int lowerPrice = Integer.MAX_VALUE;
        int profit = 0;
        // 从第一天开始遍历
        for (int i = 0; i < prices.length; i++) {
            // 维护目前为止看到的最低价
            if (prices[i] < lowerPrice) {
                lowerPrice = prices[i];
            }
            // 如果最低价买入，当天价卖出的利润更大，则更新利润
            else if (prices[i] - lowerPrice > profit) {
                profit = prices[i] - lowerPrice;
            }
        }
        return profit;
    }
}
