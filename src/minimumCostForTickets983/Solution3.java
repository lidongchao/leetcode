package minimumCostForTickets983;

/**
 * 思路 3：动态规划2
 *
 * 执行用时 :1 ms, 在所有 Java 提交中击败了97.22%的用户
 * 内存消耗 :37.9 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution3 {
    /**
     * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。
     * 每一项是一个从 1 到 365 的整数。
     *
     * 火车票有三种不同的销售方式：
     * 一张为期一天的通行证售价为 costs[0] 美元；
     * 一张为期七天的通行证售价为 costs[1] 美元；
     * 一张为期三十天的通行证售价为 costs[2] 美元。
     *
     * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，
     * 那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
     *
     * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
     *
     * 提示：
     * 1 <= days.length <= 365
     * 1 <= days[i] <= 365
     * days 按顺序严格递增
     * costs.length == 3
     * 1 <= costs[i] <= 1000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-cost-for-tickets
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param days 要旅行的日期
     * @param costs 数组，包含三个元素，分别是为期一天、七天、三十天的通行证售价
     * @return 最低消费
     */
    public int mincostTickets(int[] days, int[] costs) {

        this.days = days;
        this.costs = costs;
        // 存放从这一天开始出行所需要的最低消费
        this.memo = new Integer[days.length];

        return dp(0);
    }

    private int dp(int i) {

        if (i >= days.length) return 0;

        if (memo[i] != null) {
            return memo[i];
        }


        int j = i;
        memo[i] = Integer.MAX_VALUE;

        for (int k = 0; k < duration.length; k++) {
            while (j < days.length && days[j] - days[i] < duration[k]) {
                j++;
            }
            memo[i] = Math.min(memo[i], dp(j) + costs[k]);
        }

        return memo[i];
    }


    private int[] costs;
    private int[] days;
    private Integer[] memo;
    private static final int[] duration = {1, 7, 30};

}
