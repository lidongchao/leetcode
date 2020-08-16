package climbingStairs70;

/**
 * 思路 2：DP + 循环空间
 *
 * dp[i] = dp[i-1] + dp[i-2]
 *
 * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :36.3 MB, 在所有 Java 提交中击败了5.66%的用户
 */
class Solution2 {
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
        int p;  // -3
        int q = 0;  // -2
        int r = 1;  // -1

        for (int i = 0; i < n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

}
