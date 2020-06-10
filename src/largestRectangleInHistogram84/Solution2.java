package largestRectangleInHistogram84;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 思路 2：单调栈
 *
 * 两次维护单调栈，分别求出 left 数组和 right 数组
 *
 * 执行用时 :11 ms, 在所有 Java 提交中击败了90.14%的用户
 * 内存消耗 :40.5 MB, 在所有 Java 提交中击败了73.91%的用户
 */
class Solution2 {
    /**
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param heights 柱子高度组成的数组
     * @return 矩形的最大面积
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int ans = 0;

        // 单调递增栈
        Deque<Integer> stack = new ArrayDeque<>();

        // 存储左侧连续且大于等于当前柱子高度的柱子个数
        int[] left = new int[heights.length];
        // 存储右侧连续且大于等于当前柱子高度的柱子个数
        int[] right = new int[heights.length];

        // 构造 left 数组
        for (int i = 0; i < heights.length; i++) {
            // 当前柱子高度
            int h = heights[i];
            // 维护栈的单调递增性，从栈顶开始吃掉所有大于等于当前高度的柱子
            // 将被吃掉的柱子的 left 值连同该柱子 (+1) 一起赋值给当前柱子的 left 值
            while (!stack.isEmpty() && heights[stack.peek()] >= h) {
                int pop = stack.pop();
                left[i] += (left[pop]+1);
            }
            // 吃干净后，当前柱子入栈，仍然维持单调递增栈
            stack.push(i);
        }

        // 构造 right 数组，同时求解
        stack.clear();
        for (int i = heights.length-1; i >= 0; i--) {
            int h = heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= h) {
                int pop = stack.pop();
                right[i] += (right[pop]+1);
            }
            stack.push(i);

            // 根据当前柱子高度，以及左右两侧连续且大于等于当前柱子高度的柱子个数，
            // 求出最大矩形面积，尝试更新结果
            ans = Math.max(ans, h * (left[i] + right[i] + 1));
        }

        if (debug) {
            System.out.println(Arrays.toString(left));
            System.out.println(Arrays.toString(right));
        }

        return ans;
    }

    public Solution2() {
    }

    public Solution2(boolean debug) {
        this.debug = debug;
    }

    private boolean debug = false;

}
