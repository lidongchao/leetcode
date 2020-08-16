package integerBreak342;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路：动态规划
 *
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.3 MB, 在所有 Java 提交中击败了65.31%的用户
 */
class Solution {
    /**
     * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
     *
     * 示例 1:
     *
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1。
     * 示例 2:
     *
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
     * 说明: 你可以假设 n 不小于 2 且不大于 58。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/integer-break
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n 正整数
     * @return 拆分后的最大乘积
     */
    public int integerBreak(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        /*int maxValue = 0;
        int stopIndex = n >> 1;
        // 从 2 开始拆分，不需要拆出 1 这种无意义的方式。
        for (int i = 2; i <= stopIndex; i++) {
            int multiple = Math.max(i * integerBreak(n - i), i * (n - i));
            if (multiple > maxValue) {
                maxValue = multiple;
            }
        }*/

        // 当 n > 4 时，n < integerBreak(n)
        // 所以当一个数拆分为 x + y (y > 4) 时，一定有 (x * y) < (x * integerBreak(y))，直到拆成一堆 2 和 3。
        int maxValue = Math.max(
                Math.max(2 * (n - 2), 2 * integerBreak(n - 2)),
                Math.max(3 * (n - 3), 3 * integerBreak(n - 3))
        );

        map.put(n, maxValue);
        return maxValue;
    }

    static final Map<Integer, Integer> map = new HashMap<>();
    static {
        map.put(1, 1);  // 规定
        map.put(2, 1);  // 只有 2 和 3 需要拆出 1 (拆分为至少两个正整数)，所以这里提前算好。
        map.put(3, 2);
    }
}
