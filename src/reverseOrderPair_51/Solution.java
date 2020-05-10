package reverseOrderPair_51;

/**
 * 思路：归并排序的过程，能够有效观察到逆序对。
 *
 * 执行用时 :38 ms, 在所有 Java 提交中击败了63.56%的用户
 * 内存消耗 :50.1 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution {
    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
     *
     * 输入一个数组，求出这个数组中的逆序对的总数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 任意整数数组
     * @return 逆序对的个数
     */
    public int reversePairs(int[] nums) {
        ans = 0;
        mergeSort(nums, 0, nums.length - 1);
        return ans;
    }

    // 归并排序
    private void mergeSort(int[] nums, int p, int r) {
        if (p >= r) return;

        int q = (p + r) / 2;

        mergeSort(nums, p, q);
        mergeSort(nums, q+1, r);

        // 优化，如果左数组的最大值 <= 右数组的最小值，无需合并
        if (nums[q] <= nums[q+1]) {
            return;
        }

        // 合并左数组和右数组
        merge(nums, p, q, r);
    }

    // [i,j] 有序，[j+1,k] 有序
    private void merge(int[] nums, int p, int q, int r) {
        int[] a = new int[r - p + 1];

        int idx1 = p;
        int idx2 = q + 1;
        int idxA = 0;

        while (idx1 <= q && idx2 <= r) {
            // 左 <= 右
            if (nums[idx1] <= nums[idx2]) {
                a[idxA++] = nums[idx1++];
            }
            // 左 > 右，存在逆序对，[idx1, idx1 + 1, idx1 + 2, ... , q] 和 idx2 都可以组成逆序对
            else {
                ans += q - idx1 + 1;
                a[idxA++] = nums[idx2++];
            }
        }
        while (idx1 <= q) {
            a[idxA++] = nums[idx1++];
        }
        while (idx2 <= r) {
            a[idxA++] = nums[idx2++];
        }

        System.arraycopy(a, 0, nums, p, a.length);

    }

    private int ans;
}
