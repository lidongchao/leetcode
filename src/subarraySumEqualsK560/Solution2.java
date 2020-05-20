package subarraySumEqualsK560;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路 2：前缀和 + 哈希表优化
 *
 * 假设当前已知 [0..i] 的和为 sum，[0..j] 的和为 sum-k，那么 [j+1..i] 的和就是 k。
 * 也就是说，在 [0..j] (j=0,1..i-1) 的 i 个连续子数组中，有多少个和为 sum-k 的连续子数组，就有多少个以 i 结尾且和为 k 的连续子数组。
 *
 * 那么，可以将 [0..j] (j=0,1..i-1) 的 i 个连续子数组的和及其出现次数保存在一个哈希表中，再用 sum-k 作为 key 就能直接查询得到以 i 结
 * 尾且和为 k 的连续子数组的个数。
 *
 * 执行用时 :24 ms, 在所有 Java 提交中击败了61.66%的用户
 * 内存消耗 :40.5 MB, 在所有 Java 提交中击败了7.69%的用户
 */
class Solution2 {
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

        // 存储 [0..j] (j=0,1..i-1) 的 i 个连续子数组的和及其出现次数
        Map<Integer, Integer> mp = new HashMap<>();
        // 当 sum == k 时，也需要作为连续子数组纳入次数中
        mp.put(0, 1);

        // 一边计算 [0..i] 的和 sum，判断 sum-k 在哈希表中出现的次数，一边更新哈希表中 sum 出现的次数
        int sum = 0;
        for (int n : nums) {
            sum += n;
            ans += mp.getOrDefault(sum - k, 0);
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}
