package longestConsecutiveSequence128;

import java.util.*;

/**
 * 思路 2：排序
 *
 * 时间复杂度为 O(nlogn)，不满足题目要求
 *
 * 执行用时 :2 ms, 在所有 Java 提交中击败了99.96%的用户
 * 内存消耗 :40.4 MB, 在所有 Java 提交中击败了8.33%的用户
 */
class Solution2 {
    /**
     * 给定一个未排序的整数数组，找出最长连续序列的长度。
     * 要求算法的时间复杂度为 O(n)。
     *
     * 示例:
     * 输入: [100, 4, 200, 1, 3, 2]
     * 输出: 4
     * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 未排序的整数数组
     * @return 最长连续序列的长度
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);

        int maxLen = 1;
        int curLen = 1;

        for (int i = 0; i < nums.length-1; i++) {
            // 相同则去重，不同才比较
            if (nums[i] != nums[i+1]) {
                if (nums[i]+1 == nums[i+1]) {
                    curLen++;
                } else {
                    maxLen = Math.max(maxLen, curLen);
                    curLen = 1;
                }
            }
        }
        // 当最后一段是整数序列时，不会进入 else 语句，这里需要补齐
        maxLen = Math.max(maxLen, curLen);

        return maxLen;
    }
}
