package findInMountainArray1095;

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 *
 * 思路：二分查找
 *
 * 首先直接在山脉数组上使用外层二分查找，会出现三种现象：
 *
 * 找到目标点
 * 中点大于目标点
 * 中点小于目标点
 * 一、如果找到目标点，先观察是不是位于上坡或山顶，如果满足，直接返回。
 *
 * 否则，这个点是下坡的目标点，还需要试着找一下有没有上坡的目标点。具体做法是，将目标点左边视为单调递增的数组，进行内层的简单二分查找，找到则说明存在上坡的目标点并返回，否则返回下坡的目标点。
 *
 * 为什么能够将目标点左边视为单调递增的数组，因为虽然左边会有一段上坡和一段下坡，但是下坡的所有点都比目标点要大，所以可以简单地当作单调递增数组处理。
 *
 * 二、如果中点大于目标点，则说明目标点可能出现在左右两侧，同样根据上面的思路，可以将左边视为单调递增的数组，右边视为单调递减的数组，分别进行内层简单二分查找。
 *
 * 三、如果中点小于目标点，同样需要观察是处于上坡还是下坡 (不可能位于山顶)。
 *
 * 如果是上坡，那就在右侧再进行一次外层二分查找。
 *
 * 如果是下坡，就在左侧进行一次外层二分查找。
 *
 * 作者：dcli-2
 * 链接：https://leetcode-cn.com/problems/find-in-mountain-array/solution/bu-dang-shan-ding-dong-ren-tong-yang-ke-yi-yong-er/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :39.6 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution {
    /**
     * （这是一个 交互式问题 ）
     *
     * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
     *
     * 如果不存在这样的下标 index，就请返回 -1。
     *
     *  
     *
     * 何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：
     *
     * 首先，A.length >= 3
     *
     * 其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
     *
     * A[0] < A[1] < ... A[i-1] < A[i]
     * A[i] > A[i+1] > ... > A[A.length - 1]
     *  
     *
     * 你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：
     *
     * MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
     * MountainArray.length() - 会返回该数组的长度
     *  
     *
     * 注意：
     *
     * 对 MountainArray.get 发起超过 100 次调用的提交将被视为错误答案。此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消。
     *
     * 为了帮助大家更好地理解交互式问题，我们准备了一个样例 “答案”：https://leetcode-cn.com/playground/RKhe3ave，请注意这 不是一个正确答案。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-in-mountain-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param target 目标值
     * @param mountainArr 山脉数组
     * @return 目标值的下标
     */
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();

        // 存储上坡处可能的目标点
        int first;
        // 存储下坡处可能的目标点
        int second;


        int left = 0;
        int right = len - 1;
        // 外层二分查找
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            // 找到一个目标点
            if (midVal == target) {
                // 如果处于上坡或峰值，返回查找结果
                if (mid == 0 || mountainArr.get(mid - 1) < midVal) {
                    return mid;
                }
                // 否则，将目标点存储为下坡处目标点，将左边视为单调递增的数组，进行内层简单二分查找
                // 虽然左边会有一段上坡和一段下坡，但是下坡的所有点都比目标点要大，所以可以简单地当作单调递增数组处理
                else {
                    second = mid;
                    first = findUphill(target, mountainArr, 0, mid - 1);
                    if (first != -1) return first;
                    else return second;
                }
            }
            // 大于目标点，将左边视为单调递增的数组，右边视为单调递减的数组，分别进行内层简单二分查找
            // 理由同上
            else if (midVal > target) {
                first = findUphill(target, mountainArr, 0, mid - 1);
                if (first != -1) return first;
                second = findDownhill(target, mountainArr, mid + 1, len - 1);
                if (second != -1) return second;
                return -1;
            }
            // 小于目标点
            else {
                // 如果处于上坡，则在右侧继续外层二分查找
                if (mid == 0 || mountainArr.get(mid - 1) < midVal) {
                    left = mid + 1;
                }
                // 如果处于下坡，则在左侧继续外层二分查找
                else {
                    right = mid - 1;
                }

            }
        }
        return -1;
    }

    // 单调递增的数组上进行二分查找
    private int findUphill(int target, MountainArray mountainArr, int left, int right) {
        int mid, midVal;
        while (left <= right) {
            mid = left + (right - left) / 2;
            midVal = mountainArr.get(mid);
            if (midVal == target) {
                return mid;
            }
            else if (midVal > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // 单调递减的数组上进行二分查找
    private int findDownhill(int target, MountainArray mountainArr, int left, int right) {
        int mid, midVal;
        while (left <= right) {
            mid = left + (right - left) / 2;
            midVal = mountainArr.get(mid);
            if (midVal == target) {
                return mid;
            }
            else if (midVal > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}