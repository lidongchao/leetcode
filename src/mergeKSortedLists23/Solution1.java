package mergeKSortedLists23;

/**
 * 思路 1：每次遍历 k 个排序链表的第一个元素，得到最小结点加入新链表，最小结点所在链表同时移除该结点。直到所有排序链表为空。
 *
 * 执行用时 :333 ms, 在所有 Java 提交中击败了8.24%的用户
 * 内存消耗 :41.2 MB, 在所有 Java 提交中击败了63.23%的用户
 */
class Solution1 {
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

        while (true) {
            // 找到第一个未完成遍历的链表
            int min;
            for (min = 0; min < lists.length; min++) {
                if (null != lists[min]) break;
            }
            // 所有链表都已遍历结束，退出循环
            if (min == lists.length) break;

            int follower;
            boolean single = true;
            // 寻找所有链表中最小的结点
            for (follower = min+1; follower < lists.length; follower++) {
                if (null == lists[follower]) continue;
                single = false;
                if (lists[follower].val < lists[min].val) min = follower;
            }
            // 只剩第一个找到的链表未完成遍历，直接将剩下的所有结点加入到新的链表中，退出循环
            if (single) {
                p.next = lists[min];
                break;
            }
            // 将所有链表中最小的结点取出并加入到已排好序的新的链表中
            ListNode minNode = lists[min];
            lists[min] = lists[min].next;
            p.next = minNode;
            p = p.next;
        }
        return head.next;
    }
}
