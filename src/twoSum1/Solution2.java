package twoSum1;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路 2：HashMap 缓存已经访问过的数据
 *
 * 执行用时 :2 ms, 在所有 Java 提交中击败了99.63%的用户
 * 内存消耗 :40 MB, 在所有 Java 提交中击败了5.06%的用户
 */
class Solution2 {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 数组
     * @param target 目标值
     * @return 和为目标值的两个数的数组下标
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (indexMap.containsKey(target - n)) {
                return new int[]{i, indexMap.get(target-n)};
            } else {
                indexMap.put(n, i);
            }
        }

        return null;
     }
}
