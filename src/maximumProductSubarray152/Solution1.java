package maximumProductSubarray152;

/**
 * 思路 1：动态规划 DP
 *
 * 执行用时 :3 ms, 在所有 Java 提交中击败了39.46%的用户
 * 内存消耗 :40.2 MB, 在所有 Java 提交中击败了6.67%的用户
 */
class Solution1 {
    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 整数数组
     * @return 数组中乘积最大的连续子数组的乘积
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;

        int[] dp1 = new int[len];  //dp1[i] = max[arr(j,i)] (j=0,1,2..i)
        int[] dp2 = new int[len];  //dp2[i] = min[arr(j,i)] (j=0,1,2..i)
        dp1[0] = nums[0];
        dp2[0] = nums[0];
        int ans = dp1[0];
        for (int i = 1; i < len; i++) {
            dp1[i] = Math.max(nums[i], Math.max(dp1[i-1] * nums[i], dp2[i-1] * nums[i]));
            dp2[i] = Math.min(nums[i], Math.min(dp1[i-1] * nums[i], dp2[i-1] * nums[i]));
            ans = Math.max(ans, dp1[i]);
        }

        return ans;
    }
}
