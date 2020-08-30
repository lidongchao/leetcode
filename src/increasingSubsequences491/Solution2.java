package increasingSubsequences491;

import java.util.*;

/**
 * 思路：递归枚举
 *
 * 执行用时：3 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：47.5 MB, 在所有 Java 提交中击败了35.64%的用户
 */
class Solution2 {
    /**
     * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
     *
     * 示例:
     * 输入: [4, 6, 7, 7]
     * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
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
        current = new ArrayList<>();
        currentIndex = new ArrayList<>();
        ans = new LinkedList<>();
        dfs(nums, 0, Integer.MIN_VALUE);
        return ans;
    }

    private void dfs(int[] nums, int cur, int last) {
        if (cur == nums.length) {
            if (current.size() > 1) {
                System.out.println(currentIndex);
                ans.add(new ArrayList<>(current));
            }
            return;
        }
        // 选择 nums[cur]
        if (nums[cur] >= last) {
            current.add(nums[cur]);
            currentIndex.add(cur);
            dfs(nums, cur + 1, nums[cur]);
            current.remove(current.size() - 1);
            currentIndex.remove(currentIndex.size() - 1);
        }
        // 不选 nums[cur]
        if (nums[cur] != last) {
            // 当 nums[cur] == last 时，会有选择 nums[cur] 不选择 last、不选择 nums[cur] 选择 last 两种相同的情况，设置条件可以过滤第一种情况。
            // 如果有三个连续的数相等，那么只会出现 000 001 011 111 四种不重合的情况，其余情况都会被这一条件过滤掉。
            dfs(nums, cur + 1, last);
        }
    }

    private List<Integer> current;
    private List<Integer> currentIndex;
    private List<List<Integer>> ans;
}
