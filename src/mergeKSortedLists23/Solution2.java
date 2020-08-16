package mergeKSortedLists23;

import java.util.Comparator;
import java.util.PriorityQueue;
import utils.ListNode;

/**
 * 思路 2：优先队列维护每个链表的最小结点
 *
 * 执行用时 :5 ms, 在所有 Java 提交中击败了64.31%的用户
 * 内存消耗 :41.8 MB, 在所有 Java 提交中击败了48.53%的用户
 */
class Solution2 {
    /**
     *合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     *
     * 示例:
     *
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param lists 链表数组
     * @return 排好序的新链表
     */
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head = new ListNode(0);
        ListNode p = head;

        // 优先队列维护每个链表的最小结点
        PriorityQueue<ListNode> queue = new PriorityQueue<>((Comparator.comparingInt(o -> o.val)));

        // 初始化
        for (ListNode node : lists) {
            if (null != node) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            // 每次返回优先队列中的最小结点，也就是当前的全局最小结点
            ListNode min = queue.poll();
            // 同时将该结点的下一个结点加入优先队列中
            if (null != min.next) queue.add(min.next);
            // 最小结点加入到新的链表中
            p.next = min;
            p = p.next;
        }

        return head.next;
    }
}
