package threeSum15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思路 2：BF + 剪枝 + 双指针
 *
 * 在思路 1 的基础上进行优化，如果 i 和 j 固定，那么一旦找到 k 让 nums[i]+nums[j]+nums[k] >= 0 成立，就可以停止 k 的搜索。
 *
 * 进一步优化，i 继续保持固定，j' -> j+1，k' 只能比 k 小。形式上更像是使用双指针在有序数组中寻找两个和等于 -nums[i] 的数。
 *
 * 执行用时 :26 ms, 在所有 Java 提交中击败了56.67%的用户
 * 内存消耗 :43.5 MB, 在所有 Java 提交中击败了98.74%的用户
 */
class Solution2 {
    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
     * 请你找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums 整数数组
     * @return 不重复的和为 0 的三元组
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            // 双指针
            int j = i+1, k = nums.length-1;
            int target = -nums[i];
            // 如果重合则结束内层循环
            while (j < k) {
                // 找到满足条件的三元组
                if (nums[j] + nums[k] == target) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    // 将 j 移动到下一个不同的数
                    while (j < k && nums[j] == nums[j+1]) {
                        j++;
                    }
                    j++;
                } else if (nums[j] + nums[k] > target) {
                    k--;  // 面多加水
                } else {
                    j++;  // 水多加面
                }
            }
        }

        return ans;
    }
}
