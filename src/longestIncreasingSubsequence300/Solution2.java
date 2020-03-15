package longestIncreasingSubsequence300;

/**
 * 思路 2：动态规划法 (状态转移方程)
 *
 * 定义 dp[i] 为考虑索引为 0~i 的子数组，以 nums[i] 结尾的最长上升子序列的长度
 *
 * 在准备计算 dp[i] 时，此前已经计算得到了 dp[0] dp[1] ... dp[i-1]
 *
 * 如果让 nums[i] 加在以 nums[j] (0 <= j < i) 结尾的最长上升子序列中，那么就要求 nums[j] < nums[i]，才能保证新的仍然是上升子序列，
 * 此时该子序列的长度 dp[j] + 1，接下来从所有有效的 j 中寻找加入 i 后的最长上升子序列，作为 dp[i]，那么状态转移方程可以定义为:
 * dp[i] = max[(dp[j]) + 1 (0 <= j < i && nums[j] < nums[i])
 *
 * 执行用时 :11 ms, 在所有 Java 提交中击败了68.48%的用户
 * 内存消耗 :37.1 MB, 在所有 Java 提交中击败了13.08%的用户
 */
class Solution2 {
    /**
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     *
     * 说明:
     *  - 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
     *  - 你算法的时间复杂度应该为 O(n^2) 。
     *
     * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 无序的整数数组
     * @return 最长上升子序列的长度
     */
    public int lengthOfLIS(int[] nums) {
        if (0 == nums.length) return 0;
        int ans = 1;
        // 定义 dp 列表
        int[] dp = new int[nums.length];
        dp[0] = 1;
        // 填写 dp[i]
        for (int i = 1; i < nums.length; i++) {
            int max_dp_j = 0;
            // max_dp_j = max[(dp[j])
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max_dp_j = Math.max(dp[j], max_dp_j);
                }
            }
            // dp[i] = max_dp_j + 1
            dp[i] = max_dp_j + 1;
            // 记录最大值
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
