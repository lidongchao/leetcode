package maximumProductSubarray152;

/**
 * 思路 2：动态规划 DP + 空间优化
 *
 * 执行用时 :2 ms, 在所有 Java 提交中击败了92.56%的用户
 * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了6.67%的用户
 */
class Solution2 {
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

        int dp1 = nums[0];  //dp1[i] = max[arr(j,i)] (j=0,1,2..i)
        int dp2 = nums[0];  //dp2[i] = min[arr(j,i)] (j=0,1,2..i)
        int ans = dp1;
        for (int i = 1; i < nums.length; i++) {
            int d1 = dp1, d2=dp2;
            dp1 = Math.max(nums[i], Math.max(d1 * nums[i], d2 * nums[i]));
            dp2 = Math.min(nums[i], Math.min(d1 * nums[i], d2 * nums[i]));
            ans = Math.max(ans, dp1);
        }

        return ans;
    }
}
