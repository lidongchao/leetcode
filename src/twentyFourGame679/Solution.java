package twentyFourGame679;

/**
 * 思路：全排列
 *
 * 执行用时：1 ms, 在所有 Java 提交中击败了95.51%的用户
 * 内存消耗：37 MB, 在所有 Java 提交中击败了96.45%的用户
 */
class Solution {
    /**
     * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
     *
     * 注意:
     * 除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。
     * 每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，表达式 -1 - 1 - 1 - 1 是不允许的。
     * 你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/24-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 四个数组
     * @return 是否能够组成 24 点
     */
    public boolean judgePoint24(int[] nums) {
        return judge24(nums[0], nums[1], nums[2], nums[3]);
    }
    public boolean judge24(double n1, double n2, double n3, double n4) {
        return  judge24(n1 + n2, n3, n4) ||
                judge24(n1 - n2, n3, n4) ||
                judge24(n1 * n2, n3, n4) ||
                judge24(n1 / n2, n3, n4) ||
                judge24(n2 - n1, n3, n4) ||
                judge24(n2 / n1, n3, n4) ||

                judge24(n1 + n3, n2, n4) ||
                judge24(n1 - n3, n2, n4) ||
                judge24(n1 * n3, n2, n4) ||
                judge24(n1 / n3, n2, n4) ||
                judge24(n3 - n1, n2, n4) ||
                judge24(n3 / n1, n2, n4) ||

                judge24(n1 + n4, n2, n3) ||
                judge24(n1 - n4, n2, n3) ||
                judge24(n1 * n4, n2, n3) ||
                judge24(n1 / n4, n2, n3) ||
                judge24(n4 - n1, n2, n3) ||
                judge24(n4 / n1, n2, n3) ||

                judge24(n2 + n3, n1, n4) ||
                judge24(n2 - n3, n1, n4) ||
                judge24(n2 * n3, n1, n4) ||
                judge24(n2 / n3, n1, n4) ||
                judge24(n3 - n2, n1, n4) ||
                judge24(n3 / n2, n1, n4) ||

                judge24(n2 + n4, n1, n3) ||
                judge24(n2 - n4, n1, n3) ||
                judge24(n2 * n4, n1, n3) ||
                judge24(n2 / n4, n1, n3) ||
                judge24(n4 - n2, n1, n3) ||
                judge24(n4 / n2, n1, n3) ||

                judge24(n3 + n4, n1, n2) ||
                judge24(n3 - n4, n1, n2) ||
                judge24(n3 * n4, n1, n2) ||
                judge24(n3 / n4, n1, n2) ||
                judge24(n4 - n3, n1, n2) ||
                judge24(n4 / n3, n1, n2);
    }

    public boolean judge24(double n1, double n2, double n3) {
        return  judge24(n1 + n2, n3) ||
                judge24(n1 - n2, n3) ||
                judge24(n1 * n2, n3) ||
                judge24(n1 / n2, n3) ||
                judge24(n2 - n1, n3) ||
                judge24(n2 / n1, n3) ||

                judge24(n1 + n3, n2) ||
                judge24(n1 - n3, n2) ||
                judge24(n1 * n3, n2) ||
                judge24(n1 / n3, n2) ||
                judge24(n3 - n1, n2) ||
                judge24(n3 / n1, n2) ||

                judge24(n2 + n3, n1) ||
                judge24(n2 - n3, n1) ||
                judge24(n2 * n3, n1) ||
                judge24(n2 / n3, n1) ||
                judge24(n3 - n2, n1) ||
                judge24(n3 / n2, n1);
    }

    public boolean judge24(double n1, double n2) {
        return  judge24(n1 + n2) ||
                judge24(n1 - n2) ||
                judge24(n1 * n2) ||
                judge24(n1 / n2) ||
                judge24(n2 - n1) ||
                judge24(n2 / n1);
    }

    public boolean judge24(double n1) {
        return Math.abs(n1 - 24) < EPSILON;
    }

    private static final double EPSILON = 1e-6;
}
