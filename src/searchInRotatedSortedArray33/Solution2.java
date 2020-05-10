package searchInRotatedSortedArray33;

/**
 * 思路 2：旋转点的左右两侧都是有序数组，利用二分查找可以达到 O(log n) 的时间复杂度
 * 不再找旋转点，而是在整个数组中使用二分查找，根据中点和数组头尾两个结点的关系，判断中点左边或者右边是有序的，
 * 再判断 target 是否再有序的一侧，是的话，在有序的一侧继续二分查找，否则在另一侧二分查找。
 *
 * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :39.6 MB, 在所有 Java 提交中击败了17.74%的用户
 */
class Solution2 {
    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * 你可以假设数组中不存在重复的元素。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 数组
     * @param target 目标值
     * @return 目标值的索引，不存在返回 -1
     */
    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;

        int left, right, mid;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) return mid;
            // mid 左侧有序
            else if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // mid 右侧有序
            else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
