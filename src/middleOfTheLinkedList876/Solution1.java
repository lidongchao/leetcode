package middleOfTheLinkedList876;

/**
 * 思路 1：快慢指针，慢指针一次走一步，快指针一次走两步，当快指针指向最后一个结点或者指向 null 的时候，慢指针指向的结点就是中间结点。
 *
 * 当链表长度 n 为奇数时，快指针指向最后一个结点，走了 (n-1) 步，慢指针指向中间结点，走了 (n-1)/2 步。
 *
 * 当链表长度 n 为偶数时，快指针跨过最后一个结点指向 null，走了 n 步，慢指针指向中间两个结点的后者，走了 n/2 步。
 *
 * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :37.1 MB, 在所有 Java 提交中击败了5.05%的用户
 */
class Solution1 {
    /**
     * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     *
     * 提示：
     * 给定链表的结点数介于 1 和 100 之间。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/middle-of-the-linked-list/
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head 头结点
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if (null == head || null == head.next) return head;

        ListNode p = head, q = head;
        // 当快指针指向最后一个结点或者指向 null 的时候，慢指针指向的结点就是中间结点
        while (null != q && null != q.next) {
            // 慢指针一次走一步
            p = p.next;
            // 快指针一次走两步
            q = q.next.next;
        }
        return p;
    }
}
