package mergeIntervals56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思路 1：将区间排序，再依次扫描每一个区间，判断是否能够合并
 *
 * 执行用时 :11 ms, 在所有 Java 提交中击败了38.34%的用户
 * 内存消耗 :42.4 MB, 在所有 Java 提交中击败了39.72%的用户
 */
class Solution {
    /**
     * 给出一个区间的集合，请合并所有重叠的区间。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-intervals
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param intervals 区间集合
     * @return 合并所有重叠的区间后的区间集合
     */
    public int[][] merge(int[][] intervals) {
        if (0 == intervals.length || 1 == intervals.length) return intervals;

        // 将区间按照第一个元素的大小排序，如果第一个元素相同，则按照第二个元素的大小排序
        Arrays.sort(intervals, (o1, o2) -> {
            int i = o1[0] - o2[0];
            if (i == 0) return o1[1] - o2[1];
            else return i;
        });

        List<int[]> ans = new ArrayList<>();

        // 当前区间的范围
        int interval_start = intervals[0][0];
        int interval_end = intervals[0][1];

        // 依次扫描每个小区间
        for (int i = 1; i < intervals.length; i++) {
            // 小区间能够合并
            if (intervals[i][0] <= interval_end) {
                interval_end = Math.max(interval_end, intervals[i][1]);
            }
            // 小区间无法合并
            else {
                ans.add(new int[]{interval_start, interval_end});
                interval_start = intervals[i][0];
                interval_end = intervals[i][1];
            }
        }
        ans.add(new int[]{interval_start, interval_end});

        return ans.toArray(new int[0][]);
    }
}
