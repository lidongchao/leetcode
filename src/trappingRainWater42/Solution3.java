package trappingRainWater42;

import java.util.Stack;

/**
 * 思路 3：单调栈
 *
 * 执行用时 :5 ms, 在所有 Java 提交中击败了25.68%的用户
 * 内存消耗 :39.7 MB, 在所有 Java 提交中击败了11.78%的用户
 */
class Solution3 {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water/
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param height  柱子高度
     * @return 积水量
     */
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int ans = 0;

        // 单调递减栈
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < height.length; i++) {
            // 处理栈空
            if (stack.empty()) {
                stack.push(i);
                continue;
            }
            // 当前元素 <= 栈顶元素，当前元素入栈
            if (height[i] <= height[stack.peek()]) {
                stack.push(i);
            }
            // 当前元素 > 栈顶元素，计算积水量
            else {
                int water = 0;
                do {
                    // 栈顶元素出栈
                    final Integer lowerIdx = stack.pop();
                    // 需要和新的栈顶元素确定 V 型积水池的两端，如果此时栈空，则说明到达边界，无法积水
                    if (stack.empty()) break;
                    // 积水量 = (Min(V 型积水池的右端, V 型积水池的左端) - 积水池底) * 积水池的宽度
                    water += (Math.min(height[i], height[stack.peek()]) - height[lowerIdx]) * (i - stack.peek() - 1);
                } while (height[i] > height[stack.peek()]);
                ans += water;
                // 当前元素入栈
                stack.push(i);
            }
        }

        return ans;
    }
}
