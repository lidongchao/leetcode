package kthLargestElementInAnArray215;

import java.util.Random;

/**
 * 思路 2：基于快速排序的选择方法
 *
 * partition函数非随机选择：
 * 执行用时：15 ms, 在所有 Java 提交中击败了15.06%的用户
 * 内存消耗：40.1 MB, 在所有 Java 提交中击败了6.12%的用户
 *
 * partition函数随机选择：
 * 执行用时：2 ms, 在所有 Java 提交中击败了92.63%的用户
 * 内存消耗：40.2 MB, 在所有 Java 提交中击败了6.12%的用户
 */
class Solution2 {
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

        int left = 0, right = nums.length - 1;
        int correctIndex = k - 1;

        // 二分查找
        while (left <= right) {
            // 从 [left, right] 中随机挑选出一个值，并定位到该值在数组中的下标 mid，其左边的元素均大于 mid，右边的元素均小于 mid
            int mid = partition(nums, left, right);
            // 正好是第 k 个最大的元素，返回结果
            if (mid == correctIndex) return nums[mid];
            // 否则，在 mid 的左边或者右边继续查找
            else if (mid < correctIndex) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // 快速排序中的分区函数
    private int partition(int[] a, int p, int r) {
        // 随机选择，提升性能
        swap(a, r, random.nextInt(r - p + 1) + p);
        int pivot = a[r];

        int i = p;
        for (int j = p; j < r; j++) {
            if (a[j] > pivot) {
                if (i != j) {
                    swap(a, i, j);
                }
                i++;
            }
        }
        swap(a, i, r);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private Random random = new Random();
}
