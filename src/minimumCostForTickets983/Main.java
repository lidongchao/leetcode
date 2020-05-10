package minimumCostForTickets983;

import utils.AssertUtils;

public class Main {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();

        // 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
        // 在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
        // 在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
        // 在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
        // 你总共花了 $11，并完成了你计划的每一天旅行。
        int[] days_1 = {1,4,6,7,8,20};
        int[] costs_1 = {2,7,15};
        int expect_1 = 11;
        AssertUtils.assertEqualsInteger(expect_1, solution.mincostTickets(days_1, costs_1));

        // 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
        // 在第 1 天，你花了 costs[2] = $15 买了一张为期 30 天的通行证，它将在第 1, 2, ..., 30 天生效。
        // 在第 31 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 31 天生效。
        // 你总共花了 $17，并完成了你计划的每一天旅行。
        int[] days_2 = {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs_2 = {2,7,15};
        int expect_2 = 17;
        AssertUtils.assertEqualsInteger(expect_2, solution.mincostTickets(days_2, costs_2));


        int[] days_3 = {3,5,6,8,9,10,11,12,13,14,15,16,20,21,23,25,26,27,29,30,33,34,35,36,38,39,40,42,45,46,47,48,49,51,53,54,56,57,58,59,60,61,63,64,67,68,69,70,72,74,77,78,79,80,81,82,83,84,85,88,91,92,93,96};
        int[] costs_3 = {3,17,57};
        int expect_3 = 170;
        AssertUtils.assertEqualsInteger(expect_3, solution.mincostTickets(days_3, costs_3));
    }
}
