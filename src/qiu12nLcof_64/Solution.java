package qiu12nLcof_64;

/**
 * 思路：短路
 *
 * 执行用时 :1 ms, 在所有 Java 提交中击败了66.02%的用户
 * 内存消耗 :37.2 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution {
    /**
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     *
     * 限制：
     * 1 <= n <= 10000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/qiu-12n-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n 正整数
     * @return 1+2+...+n
     */
    public int sumNums(int n) {
        int sum = 0;
        boolean flag = (n == 0) || (sum = n + sumNums(n-1)) > 0;
        return sum;
    }
}
