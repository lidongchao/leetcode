package climbingStairs70;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路 1：BF + DP + 记忆 memo
 *
 * dp[i] = dp[i-1] + dp[i-2]
 *
 * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :36.5 MB, 在所有 Java 提交中击败了5.66%的用户
 */
class Solution1 {
    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 注意：给定 n 是一个正整数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/climbing-stairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n 总台阶数
     * @return 多少种到达楼顶的方法
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        // return climbStairs(n-1) + climbStairs(n-2);  // TLE

        int plus1, plus2;

        // dp[i-1]：到达 i-1 层的方法数
        if (memo.containsKey(n-1)) {
            plus1 = memo.get(n-1);
        } else {
            plus1 = climbStairs(n-1);
            memo.put(n-1, plus1);
        }

        // dp[i-2]：到达 i-2 层的方法数
        if (memo.containsKey(n-2)) {
            plus2 = memo.get(n-2);
        } else {
            plus2 = climbStairs(n-2);
            memo.put(n-2, plus2);
        }

        // 到达 i 层的方法数 = 到达 i-1 层的方法数 (爬 1 个台阶) + 到达 i-2 层的方法数 (爬 2 个台阶)
        // dp[i] = dp[i-1] + dp[i-2]
        return plus1 + plus2;
    }

    static private Map<Integer, Integer> memo = new HashMap<>();
}
