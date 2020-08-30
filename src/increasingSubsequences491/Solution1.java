package increasingSubsequences491;

import java.util.*;

/**
 * 思路：dp
 *
 * 在 [0 .. i .. n] 中，以 i 结尾的递增子序列由以下两部分组成：
 * 1. [0, i) 中小于等于 i 的数字加上 i
 * 2. 以 [0, i) 中小于等于 i 的数字结尾的递增子序列加上 i
 *
 * 执行用时：35 ms, 在所有 Java 提交中击败了9.93%的用户
 * 内存消耗：50.9 MB, 在所有 Java 提交中击败了7.67%的用户
 */
class Solution1 {
    /**
     * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
     *
     * 示例:
     * 输入: [4, 6, 7, 7]
     * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7, 7], [4, 7, 7]]
     * 说明:
     *
     * 给定数组的长度不会超过15。
     * 数组中的整数范围是 [-100,100]。
     * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/increasing-subsequences
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 整型数组
     * @return 所有递增子序列
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();

        // 存储以某个索引结尾的递增子序列集合
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        int n = nums.length;

        // 从前向后遍历数组
        for (int i = 0; i < n; i++) {
            // 将单个 i 作为递增子序列加入 map，但不加入结果集
            map.computeIfAbsent(i, x->new LinkedList<>()).add(Collections.singletonList(nums[i]));
            // 遍历 0 到 i 之间的数组
            for (int j = 0; j < i; j++) {
                // 满足递增条件
                if (nums[j] <= nums[i]) {
                    // 在所有以 j 结尾的递增子序列的末尾加上 i，成为新的递增子序列，加入结果集
                    for (List<Integer> list : map.get(j)) {
                        ArrayList<Integer> clonedList = new ArrayList<>(list);
                        clonedList.add(nums[i]);
                        ans.add(clonedList);
                        map.get(i).add(clonedList);
                    }
                }
            }
        }
        return new LinkedList<>(ans);
    }
}
