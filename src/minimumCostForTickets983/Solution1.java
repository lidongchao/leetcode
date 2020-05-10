package minimumCostForTickets983;

/**
 * 思路 1：回溯法，TLE
 */
class Solution1 {
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

        min = Integer.MAX_VALUE;
        mincostTickets(days, costs, 0, 0);
        return min;
    }

    private void mincostTickets(int[] days, int[] costs, int dayNow, int costNow) {
        if (dayNow >= days.length) {
            if (costNow < min) {
                min = costNow;
            }
            return;
        }

        mincostTickets(days, costs, dayNow+1, costNow + costs[0]);

        int i;
        for (i = dayNow + 1; i < days.length; i++) {
            if (days[i] - days[dayNow] >= 7) break;
        }
        mincostTickets(days, costs, i, costNow + costs[1]);

        for (i = dayNow + 1; i < days.length; i++) {
            if (days[i] - days[dayNow] >= 30) break;
        }
        mincostTickets(days, costs, i, costNow + costs[2]);
    }

    private int min;
}
