package kthLargestElementInAnArray215;

import java.util.Arrays;

/**
 * 思路 1：排序
 *
 * 执行用时：2 ms, 在所有 Java 提交中击败了92.63%的用户
 * 内存消耗：40.1 MB, 在所有 Java 提交中击败了6.12%的用户
 */
class Solution1 {
    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * 说明:
     *
     * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 数组
     * @param k 指示器
     * @return 第 k 个最大的元素
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
