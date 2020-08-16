package minimumCostToCutAStick5486;

import java.util.Arrays;

/**
 * 思路 2：动态规划
 *
 * 执行用时：565 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：40 MB, 在所有 Java 提交中击败了100.00%的用户
 */
public class Solution2 {
    /**
     * 有一根长度为 n 个单位的木棍，棍上从 0 到 n 标记了若干位置。例如，长度为 6 的棍子可以标记如下：
     * 0 [1,2,3,4,5] 6
     *
     * 给你一个整数数组 cuts ，其中 cuts[i] 表示你需要将棍子切开的位置。
     * 你可以按顺序完成切割，也可以根据需要更改切割的顺序。
     * 每次切割的成本都是当前要切割的棍子的长度，切棍子的总成本是历次切割成本的总和。
     * 对棍子进行切割将会把一根木棍分成两根较小的木棍（这两根木棍的长度和就是切割前木棍的长度）。
     * 返回切棍子的 最小总成本 。
     *
     * 提示：
     *
     * 2 <= n <= 10^6
     * 1 <= cuts.length <= min(n - 1, 100)
     * 1 <= cuts[i] <= n - 1
     * cuts 数组中的所有整数都 互不相同
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-cost-to-cut-a-stick
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n 长度
     * @param cuts 切割点
     * @return 最小代价
     */
    public int minCost(int n, int[] cuts) {

        int[] cutsPlus = new int[cuts.length + 2];
        System.arraycopy(cuts, 0, cutsPlus, 2, cuts.length);
        cutsPlus[0] = 0;
        cutsPlus[1] = n;
        Arrays.sort(cutsPlus);

        int len = cutsPlus.length;
        // dp[i][j] 代表切割 i 到 j 的绳子所需要的最小代价
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            if (i < len - 1) {
                dp[i][i + 1] = 0;
            }
        }

        return minCost(0, len - 1, cutsPlus, dp);
    }

    private int minCost(int start, int end, int[] cuts, int[][] dp) {
        if (dp[start][end] < Integer.MAX_VALUE) return dp[start][end];
        for (int mid = start + 1; mid < end; mid++) {
            dp[start][end] = Math.min(dp[start][end], minCost(start, mid, cuts, dp) + minCost(mid, end, cuts, dp) + cuts[end] - cuts[start]);
        }
        return dp[start][end];
    }
}
