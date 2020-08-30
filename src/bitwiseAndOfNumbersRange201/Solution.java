package bitwiseAndOfNumbersRange201;

/**
 * 思路：共同前缀
 *
 * 只考虑 m 和 n 两个数
 *
 * 假设 m 的最高位 1 在 im 处，n 的最高位 1 在 in 处。显然 31 >= in >= im >= 0，0 表示没有。
 *
 * 如果 im == in：
 * 那么 [m, n] 之间的所有数的最高位 1 都在 im/in 处，最终按位与得到的值，此处同样是 1。
 * 接下来去掉最高位的 1，重复上一步的操作，分析剩余位数，等价于 [m, n] 之间的所有数都减去 1 << (in - 1)。
 *
 * 如果 im != in:
 * 则出现以下情况：
 * n = 1xxxxx
 * m = 0xxxxx
 * 那么 m 到 n 之间必然有一个数 100000，这个数与 m 按位与得到 0，再与其他数按位与，最终也是 0。
 *
 * 所以只需要得到 m 和 n 的位表示的共同前缀，就是 [m, n] 范围内所有数字的按位与结果。
 *
 * 执行用时：7 ms, 在所有 Java 提交中击败了39.69%的用户
 * 内存消耗：39.1 MB, 在所有 Java 提交中击败了57.72%的用户
 */
class Solution {
    /**
     * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
     *
     * 示例 1:
     * 输入: [5,7]
     * 输出: 4
     *
     * 示例 2:
     * 输入: [0,1]
     * 输出: 0
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param m 左端点
     * @param n 右端点
     * @return 所有数字的按位与
     */
    public int rangeBitwiseAnd(int m, int n) {
        int mask = 1 << 30;
        int ans = 0;
        while (mask > 0 && (m & mask) == (n & mask)) {
            ans |= (m & mask);
            mask = mask >> 1;
        }
        return ans;
    }

//    下面这段是我写的，上面是参考优化的，思路一致
//    public int rangeBitwiseAnd(int m, int n) {
//        if (m == 0) {
//            return 0;
//        }
//
//        int ans = 0;
//        while (m > 0 && n > 0) {
//            // 分别获取 m 和 n 的最高位 bit 1
//            int hm = highestBitOfNum(m);
//            int hn = highestBitOfNum(n);
//            // 如果无法对齐，则中间的所有数字按位与的结果是 0
//            if (hm != hn) {
//                return ans;
//            } else {
//                // 能够对齐，说明 m 和 n 之间的所有数具有相同的最高位 bit 1。去掉最高位，继续比较
//                ans += hm;
//                int lowerBit = hm - 1;
//                m = m & lowerBit;
//                n = n & lowerBit;
//            }
//        }
//        return ans;
//    }
//
//    private int highestBitOfNum(int num) {
//        int scanBit = 1 << 30;
//        while (scanBit > 0) {
//            if ((scanBit & num) != 0) {
//                return scanBit;
//            } else {
//                scanBit = scanBit >> 1;
//            }
//        }
//        return 0;
//    }
}
