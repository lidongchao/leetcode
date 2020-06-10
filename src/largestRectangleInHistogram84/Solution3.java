package largestRectangleInHistogram84;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 思路 3：单调栈
 *
 * 只维护一次单调栈，直接求出 left 数组和 right 数组
 *
 * 执行用时 :13 ms, 在所有 Java 提交中击败了82.06%的用户
 * 内存消耗 :40.8 MB, 在所有 Java 提交中击败了69.57%的用户
 */
class Solution3 {
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

        int len = heights.length;
        int ans = 0;

        // 单调递增栈
        Deque<Integer> stack = new ArrayDeque<>();

        // 存储左侧第一个小于当前柱子高度的索引
        int[] left = new int[len];
        // 存储右侧第一个小于等于当前柱子高度的索引
        // 这里的"等于"在有多个相同高度时，可能会影响到左侧相同高度的柱子计算最大面积，但不会影响到最右侧相同高度的柱子
        // 例如 [3,5,4,3,2,1]，当"小于"时，right 数组为 [4, 2, 3, 4, 5, 6]，当 "小于等于"时，为 [3, 2, 3, 4, 5, 6]
        // 此时左侧的 3 无法计算出高度为 3 时的最大面积，但右侧的 3 能够准确计算出来
        int[] right = new int[len];

        // 构造 left 数组和 right 数组
        for (int i = 0; i < len; i++) {
            // 当前柱子高度
            int h = heights[i];
            // 维护栈的单调递增性，从栈顶开始吃掉所有大于等于当前高度的柱子
            // 对于被吃掉的柱子而言，当前柱子就是该柱子右侧第一个小于等于其高度的索引
            while (!stack.isEmpty() && heights[stack.peek()] >= h) {
                int pop = stack.pop();
                right[pop] = i;
            }
            // 最后栈中只剩下小于当前高度的柱子，且栈顶是左侧第一个小于当前高度的索引
            // 当栈为空时，使用左哨兵 (-1) 代表最左侧一个高度无穷小的柱子
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            // 当前柱子入栈，仍然维持单调递增栈
            stack.push(i);
        }

        // 最后留在栈中的柱子，其右侧没有小于等于其高度的柱子，所以使用右哨兵 (len) 代表最右侧一个高度无穷小的柱子
        while (!stack.isEmpty()) {
            right[stack.pop()] = len;
        }

        for (int i = 0; i < len; i++) {
            // 根据当前柱子高度、左侧第一个小于当前柱子高度的索引、右侧第一个小于等于当前柱子高度的索引，
            // 求出最大矩形面积，尝试更新结果
            ans = Math.max(ans, heights[i] * (right[i] - left[i] - 1));
        }

        if (debug) {
            System.out.println(Arrays.toString(left));
            System.out.println(Arrays.toString(right));
        }

        return ans;
    }

    public Solution3() {
    }

    public Solution3(boolean debug) {
        this.debug = debug;
    }

    private boolean debug = false;

}
