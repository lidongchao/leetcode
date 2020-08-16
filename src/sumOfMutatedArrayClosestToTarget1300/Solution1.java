package sumOfMutatedArrayClosestToTarget1300;

import java.util.Arrays;

/**
 * 思路：二分查找
 *
 * 执行用时 :5 ms, 在所有 Java 提交中击败了34.84%的用户
 * 内存消耗 :40.4 MB, 在所有 Java 提交中击败了16.67%的用户
 */
class Solution1 {
    /**
     * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，
     * 数组的和最接近  target （最接近表示两者之差的绝对值最小）。
     *
     * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
     *
     * 请注意，答案不一定是 arr 中的数字。
     *
     * 提示：
     *
     * 1 <= arr.length <= 10^4
     * 1 <= arr[i], target <= 10^5
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param arr 正整数数组
     * @param target 目标值
     * @return 整数 value，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target
     */
    public int findBestValue(int[] arr, int target) {

        int max = Arrays.stream(arr).max().orElse(0);
        int left = 0;
        int right = max;

        // 二分搜索：在 0 到 max(arr) 中找到一个数 value，使得 sum(arr, value) 与 target 最接近
        while (left <= right) {
            int mid = left + (right-left) / 2;
            int sum = sum(arr, mid);

            // 是否需要考虑 sum(arr, mid) == sum(arr, mid-1) == target 的情况？==> 不需要。
            // 因为如果出现这种情况，说明 mid 大于 arr 中的所有值，这与 mid 语义不符。
            if (sum == target) {  // == target
                return mid;
            } else if (sum < target) {  // < target
                int sumPlus = sum(arr, mid + 1);
                if (sumPlus > target) {
                    return (target - sum) <= (sumPlus - target) ? mid : mid + 1;
                } else {
                    left = mid + 1;
                }
            } else {  // > target
                int sumMinus = sum(arr, mid - 1);
                if (sumMinus < target) {
                    return (target - sumMinus) <= (sum - target) ? mid - 1 : mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return max;
    }

    // 计算数组的和，将数组中所有大于 value 的值当作 value
    private int sum(int[] arr, int value) {
        int sum = 0;
        for (int i : arr) {
            sum += Math.min(i, value);
        }
        return sum;
    }
}