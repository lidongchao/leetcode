package maxQueue59;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 普通队列正常维护所有入队的数据，辅助队列维护普通队列中的最大值和潜在的最大值，以及这些值的在普通队列中的顺序。
 *
 * 具体来说，普通队列 (以下简称队列) 中的最大值应该出现在辅助队列的头部，而在最大值前面入队的数据，就没有必要出现在辅助队列中，
 * 因为这些数据的出队，不会影响到队列中的最大值。从另一个角度看，辅助队列中，最大值把前面比自己小的值都"吃"掉了。
 *
 * 但是在最大值后面入队的数据，仍需要判断是否是潜在的最大值，"潜在"的含义是当最大值出队后，辅助队列的最大值同时出队，
 * 然后队列新的最大值应该出现在辅助队列的头部。
 *
 * 为了达到这个目的，需要将最大值后面入队的所有数据中，局部最大的数放在辅助队列的第二位，该值不一定是当前整个队列第二大的数。
 * 同样的在辅助队列中，看起来像是这个"潜在"的最大值把前面比自己小的值都"吃"掉了，直到遇到了比自己大 (或相同) 的真正的最大值。
 *
 * 如果这个"潜在"的最大值后面还有数据，则继续寻找"潜在"的最大值，追加在辅助队列中。
 *
 * 最终这个辅助队列的值是单调不增的，且数据的顺序与其在普通队列中的顺序一致。
 *
 * 执行用时 :37 ms, 在所有 Java 提交中击败了81.88%的用户
 * 内存消耗 :45.2 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class MaxQueue {

    /**
     * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的时间复杂度都是O(1)。
     *
     * 若队列为空，pop_front 和 max_value 需要返回 -1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public MaxQueue() {
        queue = new ArrayDeque<>();
        maxKeeper = new ArrayDeque<>();
    }

    /**
     * 返回队列的最大值，该值维护在辅助队列 maxkeeper 的头部。如果队列为空，返回-1
     * @return 队列的最大值
     */
    public int max_value() {
        if (maxKeeper.isEmpty()) return -1;
        return maxKeeper.peekFirst();
    }

    /**
     * 向队列的尾部加入一条新的数据，同时将该数据加入到辅助队列的末端，
     * 然后，该数据会"吃"掉前面比自己小的数，因为这些被"吃"掉的数由于最后这条数据的加入，已经不可能成为队列中的最大值。
     * @param value 加入队列尾部的值
     */
    public void push_back(int value) {
        queue.add(value);
        while (!maxKeeper.isEmpty() && maxKeeper.peekLast() < value) {
            maxKeeper.pollLast();
        }
        maxKeeper.addLast(value);
    }

    /**
     * 返回并移除队列头部的数据，如果该数据和辅助队列头部的数据相等，说明移除的是队列的最大值，同时移除辅助队列头部的数据。
     * 如果队列为空，返回-1
     * @return 队列头部的数据
     */
    public int pop_front() {
        if (queue.isEmpty()) return -1;
        int top = queue.poll();
        if (top == maxKeeper.peekFirst()) {
            maxKeeper.pollFirst();
        }
        return top;
    }

    private Queue<Integer> queue;
    private Deque<Integer> maxKeeper;
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */