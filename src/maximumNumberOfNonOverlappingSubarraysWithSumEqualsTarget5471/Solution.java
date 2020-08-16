package maximumNumberOfNonOverlappingSubarraysWithSumEqualsTarget5471;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 思路：哈希 + 前缀和 + 贪心
 *
 * 执行用时：239 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：56.5 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution {
    /**
     * 给你一个数组 nums 和一个整数 target 。
     * 请你返回 非空不重叠 子数组的最大数目，且每个子数组中数字和都为 target 。
     *
     * 示例 1：
     * 输入：nums = [1,1,1,1,1], target = 2
     * 输出：2
     * 解释：总共有 2 个不重叠子数组（加粗数字表示） [1,1,1,1,1] ，它们的和为目标值 2 。
     *
     * 示例 2：
     * 输入：nums = [-1,3,5,1,4,2,-9], target = 6
     * 输出：2
     * 解释：总共有 3 个子数组和为 6 。
     * ([5,1], [4,2], [3,5,1,4,2,-9]) 但只有前 2 个是不重叠的。
     *
     * 提示：
     * 1 <= nums.length <= 10^5
     * -10^4 <= nums[i] <= 10^4
     * 0 <= target <= 10^6
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 数组
     * @param target 目标值
     * @return 非空不重叠子数组的最大数目
     */
    public int maxNonOverlapping(int[] nums, int target) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();  // 存储数组前缀和及其索引
        map.computeIfAbsent(0, x->new LinkedList<>()).add(-1);  // 规定

        List<int[]> res = new LinkedList<>();

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 查找是否有另一个前缀和使得 sum[0..i] - sum[0..idx] = target，即 sum[idx+1...i] = target
            List<Integer> idxs = map.get(sum - target);
            if (idxs != null) {
                for (Integer idx : idxs) {
                    // 贪心，只有不和上一个重叠，才放进去
                    if (res.isEmpty() || idx >= res.get(res.size() - 1)[1]) {
                        res.add(new int[]{idx + 1, i});
                    }
                }
            }
            // 存储前缀和
            map.computeIfAbsent(sum, x->new LinkedList<>()).add(i);
        }
        return res.size();
    }

}
