package superEggDrop887;

import java.util.HashMap;

/**
 * 思路 2：动态规划 + 二分查找
 *
 * 执行用时 :81 ms, 在所有 Java 提交中击败了27.16%的用户
 * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了26.09%的用户
 */
class Solution2 {
    /**
     * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
     * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
     * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
     * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
     * 你的目标是确切地知道 F 的值是多少。
     * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
     *
     * 提示：
     * 1 <= K <= 100
     * 1 <= N <= 10000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/super-egg-drop
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param K 鸡蛋个数
     * @param N 楼层数
     * @return 确定 F 值的最小移动次数
     */
    public int superEggDrop(int K, int N) {
        return dp(K, N);
    }

    private int dp(int K, int N) {
        if (K == 0) {
            return 0;
        }
        if (K == 1) {
            return N;
        }
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }

        if (memo.containsKey(N*1000 + K)) return memo.get(N*1000 + K);

        int start = 1, end = N;
        int X, dp2, dp1;

        // !!!!! 只要 start 和 end 相邻，就退出循环，此时 dp1 一定不等于 dp2，且在 start 点上 dp1 < dp2，在 end 点上 dp1 > dp2
        // 这种二分查找方法，用于查找非精确值，重新选择范围的时候是 start = X 或 end = X，保证 start 和 end 不会重合
        while(start + 1 < end) {
            // 从 X 楼扔鸡蛋
            X = (start + end) / 2;
            // 碎了，返回值随 X 增加单调递增
            dp1 = dp(K - 1, X - 1);
            // 没碎，返回值随 X 增加单调递减
            dp2 = dp(K, N - X);

            // 只有 dp1 dp2 两个返回值相同或接近 (差值为 1)，才能保证 max(dp1, dp2) 是最小的。
            if (dp1 == dp2) {
                // dp1 和 dp2 相同的情况下 X 点就是理想点。
                start = end = X;
            } else if (dp1 < dp2) {
                start = X;
            } else {
                end = X;
            }
        }

        // 计算 start 点和 end 点的 dp 值，返回更小的。
        int left = Math.max(dp(K - 1, start - 1), dp(K, N - start));
        int right = Math.max(dp(K - 1, end - 1), dp(K, N - end));
        int min = Math.min(left, right) + 1;
        memo.put(N*1000 + K, min);
        return min;

    }

    private HashMap<Integer, Integer> memo = new HashMap<>();
}
