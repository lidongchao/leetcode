package powXN50;

/**
 * 执行用时 :1 ms, 在所有 Java 提交中击败了94.50%的用户
 * 内存消耗 :37.1 MB, 在所有 Java 提交中击败了5.88%的用户
 */
class Solution {
    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
     *
     * 说明:
     * -100.0 < x < 100.0
     * n 是 32 位有符号整数，其数值范围是 [−2147483648, 2147483647] 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/powx-n
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param x 底数
     * @param n 幂数
     * @return x 的 n 次幂
     */
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == -1) return 1/x;
        if (x == 1) return 1;
        if (x == -1) return (n & 1) == 1 ? -1 : 1;

        boolean negative = false;
        if (n < 0) {
            negative = true;
            n = -(n+1);  // 防止 -2147483648 求反溢出，但是 -1 就会变为 0，所以在开始处理
        }

        double res = powRecursive(x, n);

        if (negative) {
            return 1 / (res * x);
        } else {
            return res;
        }
    }

    private double powRecursive(double x, int n) {
        if (n == 1) return x;

        double v = powRecursive(x, n / 2);
        // 如果 n 是奇数
        if ((n & 1) == 1) {
            return v * v * x;
        } else {
            return v * v;
        }
    }
}
