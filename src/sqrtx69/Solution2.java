package sqrtx69;

/**
 * 思路 2：exp 和 ln 代替 sqrt
 *
 * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :36.9 MB, 在所有 Java 提交中击败了5.55%的用户
 */
class Solution2 {
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
        if (x == 0) return 0;

        // sqrt(x) = pow(x, 1/2) = pow(exp(log(x)), 1/2) = exp(1/2 * log(x))
        int ans = (int) Math.exp(0.5 * Math.log(x));

        // 由于计算机无法存储浮点数的精确值，而指数函数和对数函数的参数和返回值均为浮点数，因此运算过程中会存在误差
        // 例如当 x = 2147395600 时，会得到 46339 这个错误的结果，而正确结果是 46340
        return (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }
}
