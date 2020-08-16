package sumOfMutatedArrayClosestToTarget1300;

import java.util.Arrays;

/**
 * 思路：双重二分查找
 *
 * 执行用时 :5 ms, 在所有 Java 提交中击败了34.84%的用户
 * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了50.00%的用户
 */
class Solution2 {
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
        int len = arr.length;
        Arrays.sort(arr);

        // 计算前缀和
        int[] prefixSum = new int[len+1];
        for (int i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i-1];
        }

        int max = arr[len - 1];

        int left = 0;
        int right = max;
        int leftIndex = 0;
        int rightIndex = len - 1;
        int mid;
        int midIndex;
        int sum;

        // 二分搜索：在 0 到 max(arr) 中找到一个数 value，使得 sum(arr, value) 与 target 最接近
        while (left <= right) {
            mid = left + (right - left) / 2;
            /* int sum = sum(arr, mid); */
            midIndex = binarySearch(arr, leftIndex, rightIndex, mid);
            sum = prefixSum[midIndex] + (len - midIndex) * mid;

            // 是否需要考虑 sum(arr, mid) == sum(arr, mid-1) == target 的情况？==> 不需要。
            // 因为如果出现这种情况，说明 mid 大于 arr 中的所有值，这与 mid 语义不符。
            if (sum == target) {  // == target
                return mid;
            } else if (sum < target) {  // < target
                /* int sumPlus = sum(arr, mid + 1); */
                int midPlusIndex = binarySearch(arr, leftIndex, rightIndex, mid + 1);
                int sumPlus = prefixSum[midPlusIndex] + (len - midPlusIndex) * (mid + 1);
                if (sumPlus > target) {
                    return (target - sum) <= (sumPlus - target) ? mid : mid + 1;
                } else {
                    left = mid + 1;
                    leftIndex = midIndex;
                }
            } else {  // > target
                /* int sumMinus = sum(arr, mid - 1); */
                // 因为 midIndex 左侧的数全都小于 mid，右侧的数全都大于等于 mid，所以可以直接让 midIndex 右侧的数全部变为 mid-1
                // int midMinusIndex = binarySearch(arr, mid - 1);
                int sumMinus = prefixSum[midIndex] + (len - midIndex) * (mid - 1);
                if (sumMinus < target) {
                    return (target - sumMinus) <= (sum - target) ? mid - 1 : mid;
                } else {
                    right = mid - 1;
                    rightIndex = midIndex;
                }
            }
        }
        return max;
    }

    // 如果存在 key，返回第一个 key 的索引
    // 如果不存在 key，返回第一个大于 key 的数的索引
    private int binarySearch(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high-low) / 2;

            if (arr[mid] == key) {  // == key
                if (mid == 0 || arr[mid-1] != key) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (arr[mid] > key) {  // > key
                if (mid == 0 || arr[mid-1] < key) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {  // < key
                if (mid == arr.length - 1 || arr[mid+1] > key) {
                    return mid + 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
