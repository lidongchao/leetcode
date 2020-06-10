package longestConsecutiveSequence128;

import java.util.HashSet;

/**
 * 思路 3：HashSet
 *
 * 如果数据全部存放在 HashSet 中，那么拿到一个数 n，能在 O(1) 时间内判断 n+1 是否存在，O(n) 时间内判断 n 所在连续序列的长度
 *
 * 对于每个数，都通过该方法判断所在连续序列的长度，最终时间复杂度为 O(n^2)
 *
 * 但是，如果规定，对于一个数 n，只有当 n-1 不存在时，才进行判断，那么每个连续序列只需要遍历一次，且每次都是从该连续序列的最小值开始，
 * 时间复杂度为 O(n)
 *
 * 执行用时 :5 ms, 在所有 Java 提交中击败了82.66%的用户
 * 内存消耗 :40.2 MB, 在所有 Java 提交中击败了8.33%的用户
 */
class Solution3 {
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

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 1;
        int curLen = 1;
        for (int num : nums) {
            // 剪枝：只有当 num-1 不存在时才继续判断
            if (!set.contains(num-1)) {
                // 判断 num+1 num+2 ... 是否存在
                while (set.contains(num+curLen)) {
                    curLen++;
                }
                // 更新最大长度
                maxLen = Math.max(maxLen, curLen);
                curLen = 1;
            }
        }

        return maxLen;
    }
}
