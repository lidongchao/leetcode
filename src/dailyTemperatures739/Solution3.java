package dailyTemperatures739;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 思路 3：最小栈
 *
 * 通过维护一个最小栈，记录每个温度之后最近的更高温度
 *
 * 例如 [73, 74, 75, 71, 69, 72, 76, 73]
 *
 * 栈的变化信息如下：
 * []
 * 73 -> [0]
 * 74 -> [1] -> 73(ans[0]=1-0)
 * 75 -> [2] -> 74(ans[1]=2-1)
 * 71 -> [2,3]
 * 69 -> [2,3,4]
 * 72 -> [2,5] -> 69(ans[4]=5-4) 71(ans[3]=5-3)
 * 76 -> [6] -> 72(ans[5]=6-5) 75(ans[2]=6-2)
 * 73 -> [6,7]
 *
 * 最终留在栈中的下标，代表其气温在这之后都不会升高
 * ans[6]=0 ans[7]=0
 *
 * 执行用时 :20 ms, 在所有 Java 提交中击败了81.87%的用户
 * 内存消耗 :49.2 MB, 在所有 Java 提交中击败了6.45%的用户
 */
class Solution3 {
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

        // 最小栈，存储索引，保证索引对应的温度是单调不增的
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int top = stack.pop();
                ans[top] = i - top;
            }
            stack.push(i);
        }
        return ans;
    }
}
