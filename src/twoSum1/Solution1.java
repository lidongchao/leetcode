package twoSum1;

/**
 * 思路 1：BF 暴力搜索
 *
 * 执行用时 :109 ms, 在所有 Java 提交中击败了9.88%的用户
 * 内存消耗 :40 MB, 在所有 Java 提交中击败了5.06%的用户
 */
class Solution1 {
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
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
     }
}
