package dailyTemperatures739;

import java.util.Arrays;

/**
 * 思路 2：BF 优化
 *
 * 执行用时 :13 ms, 在所有 Java 提交中击败了90.42%的用户
 * 内存消耗 :47.7 MB, 在所有 Java 提交中击败了6.45%的用户
 */
class Solution2 {
    /**
     * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
     * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
     *
     * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
     *
     * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/daily-temperatures
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param T 气温列表
     * @return 想要观测到更高的温度，至少需要等待的天数组成的列表
     */
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] ans = new int[len];
        // 气温是分布在 [30, 100] 范围内的整数
        // 使用一个数组存储每个温度最新的数组下标，初始化为 MAX
        int[] tempIndex = new int[101];
        Arrays.fill(tempIndex, Integer.MAX_VALUE);

        // 从后往前遍历，保证每一时刻看到 tempIndex 中的温度以及下标都是离自身最近的
        for (int i = len-1; i >= 0; i--) {
            int temp = T[i];
            // 在 tempIndex 的 [temp+1, 100] 中找到下标最小的值，作为最近的更大值
            int minIndex = Integer.MAX_VALUE;
            for (int j = temp+1; j <= 100; j++) {
                minIndex = Math.min(minIndex, tempIndex[j]);
            }
            // 找到：至少等待 minIndex - i 天。找不到：0
            ans[i] = minIndex == Integer.MAX_VALUE ? 0 : minIndex - i;
            // 更新温度的最新下标
            tempIndex[temp] = i;
        }
        return ans;
    }
}
