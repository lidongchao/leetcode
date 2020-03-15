package longestIncreasingSubsequence300;

/**
 * 思路 3：贪心 + 二分查找
 *
 * 以思路 1 为基础，输入数组为 [10,9,2,5,3,7,101,18]，打印出 states 为
 * [0, 10, 0, 0, 0, 0, 0, 0, 0]  <-- 插入 10
 * [0, 9, 0, 0, 0, 0, 0, 0, 0]   <-- 插入 9，9 <= 10，9 替换 10
 * [0, 2, 0, 0, 0, 0, 0, 0, 0]   <-- 插入 2，2 <= 9，2 替换 9
 * [0, 2, 5, 0, 0, 0, 0, 0, 0]   <-- 插入 5，5 > 2，新增 5
 * [0, 2, 3, 0, 0, 0, 0, 0, 0]   <-- 插入 3，3 <= 5，3 替换 5
 * [0, 2, 3, 7, 0, 0, 0, 0, 0]   <-- 插入 7，7 > 3，新增 7
 * [0, 2, 3, 7, 101, 0, 0, 0, 0] <-- 插入 101，101 > 7，新增 101
 * [0, 2, 3, 7, 18, 0, 0, 0, 0]  <-- 插入 18，18 <= 101，18 替换 101
 *
 * 能够看出这里使用到了贪心的思想，让上升子序列尽可能长、尽可能平缓
 *
 * 其次，无需维护一个矩阵，只需要维护一个递增数组即可
 *
 * 最后，既然是递增数组，那么可以利用二分查找进一步缩短执行时间
 *
 * 因此程序变为：
 * 1. 维护一个长度为 n 的状态数组，数组 0 号元素初始化为 nums[0]
 * 2. 从 num[1] 开始判断：
 *     2.1 如果元素比状态数组最后一个状态元素更大，那么追加到状态数组的末尾，长度加一
 *     2.2 否则，通过二分查找找到大于等于该元素的最小状态元素，并替换之
 *
 * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :37.98 MB, 在所有 Java 提交中击败了5.07%的用户
 */
class Solution3 {
    /**
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     *
     * 说明:
     *  - 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
     *  - 你算法的时间复杂度应该为 O(n^2) 。
     *
     * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 无序的整数数组
     * @return 最长上升子序列的长度
     */
    public int lengthOfLIS(int[] nums) {
        if (0 == nums.length) return 0;
        // 初始化长度为 1，首先将 num[0] 考虑进来
        int ans = 1;
        // 定义一个状态数组，初始化第 0 号元素
        int[] states = new int[nums.length];
        states[0] = nums[0];
        // 从 num[1] 开始判断
        for (int i = 1; i < nums.length; i++) {
            // 如果元素比状态数组最后一个状态元素更大，那么追加到状态数组的末尾，长度加一
            if (nums[i] > states[ans-1]) {
                states[ans++] = nums[i];
            }
            // 否则，通过二分查找找到大于等于该元素的最小状态元素，并替换之
            else {
                states[findPos(states, 0, ans-1, nums[i])] = nums[i];
            }
        }

        return ans;
    }

    private int findPos(int[] nums, int start, int end, int key) {
        if (start == end) { return start; }
        int midPos = (start+end)>>1;
        if (key == nums[midPos]) { return midPos; }
        else if (key > nums[midPos]) { return findPos(nums, midPos+1, end, key); }
        else { return findPos(nums, start, midPos, key); }
    }
}
