package minStack155;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 思路：辅助栈
 *
 * 执行用时 :9 ms, 在所有 Java 提交中击败了39.14%的用户
 * 内存消耗 :41.3 MB, 在所有 Java 提交中击败了15.66%的用户
 */
class MinStack {

    /**
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     *
     * push(x) —— 将元素 x 推入栈中。
     * pop() —— 删除栈顶的元素。
     * top() —— 获取栈顶元素。
     * getMin() —— 检索栈中的最小元素。
     *
     * 提示：
     * pop、top 和 getMin 操作总是在 非空栈 上调用。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/min-stack
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int x) {
        // 数据入栈
        stack.push(x);
        // 如果辅助栈为空 或者 辅助栈的栈顶元素大于等于 x，说明数据栈的最小值大于等于 x，将 x 压入辅助栈
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        // 数据出栈
        // 如果出栈的元素正好也是辅助栈的栈顶元素，那么该数据同样出辅助栈
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

}
