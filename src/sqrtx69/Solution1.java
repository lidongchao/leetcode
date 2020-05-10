package sqrtx69;

/**
 * 思路 1：二分查找
 *
 * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :36.9 MB, 在所有 Java 提交中击败了5.55%的用户
 */
class Solution1 {
    /**
     * 实现 int sqrt(int x) 函数。
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sqrtx
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param x 被平方根数
     * @return x 的平方根的整数部分
     */
    public int mySqrt(int x) {
        // 在 [0, x] 之间寻找平方根
        int low = 0;
        int high = x;

        int mid;
        int ans = 0;

        // 二分查找
        while (low <= high) {
            mid = low + ((high - low ) >> 1);
            // 小于或等于 x，记录 mid，在右边继续寻找
            if ((long)mid * mid <= x) {
                ans = mid;
                low = mid + 1;
            }
            // 大于 x，在左边继续寻找
            else {
                high = mid - 1;
            }

        }
        return ans;
    }
}
