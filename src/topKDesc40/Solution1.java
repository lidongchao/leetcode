package topKDesc40;

import java.util.Arrays;

/**
 * 思路 1：暴力求解，排序，输出
 *
 * 执行用时 :10 ms, 在所有 Java 提交中击败了51.79%的用户
 * 内存消耗 :42.8 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution1 {
    /**
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     *
     * 限制：
     * 0 <= k <= arr.length <= 10000
     * 0 <= arr[i] <= 10000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param arr 整数数组
     * @param k 最小的个数
     * @return 整数数组中最小的 k 个数
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ans = new int[k];

        Arrays.sort(arr);
        for (int i = 0; i < k && i < arr.length; i++) {
            ans[i] = arr[i];
        }

        return ans;
    }

}
