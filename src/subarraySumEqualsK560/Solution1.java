package subarraySumEqualsK560;

/**
 * 思路 1：BF 暴力枚举
 *
 * 执行用时 :426 ms, 在所有 Java 提交中击败了14.92%的用户
 * 内存消耗 :41.3 MB, 在所有 Java 提交中击败了7.69%的用户
 */
class Solution1 {
    /**
     * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
     *
     * 说明 :
     * 数组的长度为 [1, 20,000]。
     * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 整数数组
     * @param k 需要找出的连续子数组的和
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) ans++;
            }
        }

        return ans;

    }
}
