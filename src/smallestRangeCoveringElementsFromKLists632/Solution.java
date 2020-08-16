package smallestRangeCoveringElementsFromKLists632;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 思路：堆
 *
 * 执行用时：35 ms, 在所有 Java 提交中击败了76.77%的用户
 * 内存消耗：45.4 MB, 在所有 Java 提交中击败了61.11%的用户
 */
class Solution {
    /**
     * 你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
     *
     * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
     *
     * 示例 1:
     * 输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
     * 输出: [20,24]
     *
     * 解释:
     * 列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
     * 列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
     * 列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
     *
     * 注意:
     * 1. 给定的列表可能包含重复元素，所以在这里升序表示 >= 。
     * 2. 1 <= k <= 3500
     * 3. -10^5 <= 元素的值 <= 10^5
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums k 个升序排列的整数数组
     * @return 最小区间
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        int rangeRight = 100000;  // 最小区间的上界
        int rangeLeft = -100000;  // 最小区间的下界
        int rangeSize = rangeRight - rangeLeft;  // 最小区间的大小
        int upper = Integer.MIN_VALUE;  // 当前区间的上界

        // 小顶堆
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
        // 初始化时，取出每个数组的第一个元素，放入小顶堆
        for (List<Integer> num : nums) {
            Integer value = num.get(0);
            Node node = new Node(0, value);
            node.setArray(num);
            priorityQueue.offer(node);
            upper = Math.max(upper, value);  // 计算这些元素的最大值，作为当前区间的上界
        }

        while (!priorityQueue.isEmpty()) {
            Node lowerNode = priorityQueue.poll();  // 从小顶堆取出堆顶元素
            int lower = lowerNode.value;  // 堆顶元素的值是堆中元素的最小值，作为当前区间的下届
            if (upper - lower < rangeSize) {  // 判断当前区间是否比最小区间更小
                rangeLeft = lower;
                rangeRight = upper;
                rangeSize = rangeRight - rangeLeft;
            }
            if (lowerNode.isLast()) {  // 如果 lowerNode 是所在数组的最后一个元素，继续往后寻找，则该数组不再有值包含在区间中，不符合题意
                break;
            }
            Node next = lowerNode.getNext();  // 取 lowerNode 所在数组的下一个值，代替它加入小顶堆，保证每个数组有一个值在小顶堆中
            priorityQueue.offer(next);
            upper = Math.max(upper, next.value);  // 检查是否需要更新当前区间的上界
        }

        return new int[]{rangeLeft, rangeRight};

    }

    // 数组中每个元素的代理，记录元素的值和索引，以及所属数组
    static class Node {
        public Node(int offset, int value) {
            this.offset = offset;
            this.value = value;
        }

        // 设置背靠的数组
        public void setArray(List<Integer> array) {
            this.array = array;
        }

        // 应该返回一个新的 Node，但是复用对象能够减少对象的创建
        public Node getNext() {
            offset++;
            value = array.get(offset);
            return this;
        }

        // 检查是否是最后一个元素
        public boolean isLast() {
            return offset + 1 >= array.size();
        }

        int offset;
        int value;
        List<Integer> array;  // back

    }
}
