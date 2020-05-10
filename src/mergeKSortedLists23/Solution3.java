package mergeKSortedLists23;

/**
 * 思路 3：分治，两两合并
 *
 * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :41.8 MB, 在所有 Java 提交中击败了48.53%的用户
 */
class Solution3 {
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
        return mergeKLists(lists, 0, lists.length - 1);
    }

    /**
     * 对 k 个链表进行归并排序
     * @param lists 链表数组
     * @param p 待排序的第一个链表
     * @param r 待排序的最后一个链表
     * @return 排好序的链表
     */
    private ListNode mergeKLists(ListNode[] lists, int p, int r) {
        if (p == r) return lists[p];
        if (p > r) return null;
        int q = p + (r - p) / 2;
        ListNode left = mergeKLists(lists, p, q);
        ListNode right = mergeKLists(lists, q + 1, r);
        return mergeTwoList(left, right);
    }

    /**
     * 对两个链表进行排序
     * @param l1 第一个链表
     * @param l2 第二个链表
     * @return 排好序的链表
     */
    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (null == l1 || null == l2) return null != l1 ? l1 : l2;

        ListNode head = new ListNode(0);
        ListNode p = head;

        while (null != l1 && null != l2) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (null != l1) {
            p.next = l1;
        }
        if (null != l2) {
            p.next = l2;
        }
        return head.next;
    }
}
