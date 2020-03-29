package bestTimeToBuyAndSellStock121;

/**
 * 思路 1：维护一个最大价格差的区间，区间初始化为第一天买入，第一天卖出，利润为 0
 *
 * 然后不断判断后续的时间是加入到区间中，还是忽略掉，还是用新的区间替换现有的区间
 *
 * 执行用时 :1 ms, 在所有 Java 提交中击败了99.57%的用户
 * 内存消耗 :42.6 MB, 在所有 Java 提交中击败了5.02%的用户
 */
class Solution1 {
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

        // 维护一个区间，在区间的起点买入，在区间的终点卖出，只记录区间起点和终点的价格，如果有必要，还可以记录区间的坐标
//        int buyTime = 0;
//        int sellTime = 0;
//        int lowerTime = -1;
        int buyPrice = prices[0];
        int sellPrice = prices[0];
        int lowerPrice = Integer.MAX_VALUE;

        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];
            // 当前点到最低点的价格差 > 区间的价格差，用新的区间替换老的区间
            if ((currentPrice - lowerPrice) >= (sellPrice - buyPrice)) {
                buyPrice = lowerPrice;
                sellPrice = currentPrice;
                lowerPrice = Integer.MAX_VALUE;
            }
            // 当前点价格大于区间终点的价格，则更新区间的终点
            else if (currentPrice >= sellPrice) {
                sellPrice = currentPrice;
            }
            // 当前点价格小于区间起点的价格，且小于最低点，那么更新最低点
            else if ( currentPrice < lowerPrice && currentPrice < buyPrice) {
                lowerPrice = currentPrice;
            } else {
                // do nothing
            }
        }
        return sellPrice - buyPrice;
    }
}
