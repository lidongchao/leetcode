package longestConsecutiveSequence128;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路 4：并查集 2
 *
 *执行用时 :6 ms, 在所有 Java 提交中击败了58.58%的用户
 * 内存消耗 :40.2 MB, 在所有 Java 提交中击败了8.33%的用户
 */
class Solution4 {
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

        // 初始化每个数都指向下一个数，自然产生一个完成初步合并的并查集
        map = new HashMap<>();
        for (int num : nums) {
            map.put(num, num+1);
        }

        // 再次遍历每个数
        int maxLen = 0;
        for (int num : nums) {
            // last-1 是 num 所属并查集中最大的数，last 一定不存在于集合中
            int last = find(num);
            maxLen = Math.max(maxLen, last - num);
        }

        return maxLen;
    }

    // 每个数 x 都能找到所属并查集中最大的数加一
    // 当一个数 x 第一次调用 find 时，map.get(x) 一定指向其后一个数 x+1，如果 x+1 也在集合中，则继续对 x+1 调用 find，
    // 直到 x+n 不存在于集合中，此时 map.get(x) = map.get(x+1) = ... = map.get(x+n-1) = x+n
    private int find(int x) {
        int nextX = map.get(x);
        if (map.containsKey(nextX)) map.put(x, find(nextX));
        return map.get(x);
    }

    private Map<Integer, Integer> map;
}
