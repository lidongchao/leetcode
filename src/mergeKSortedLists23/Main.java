package mergeKSortedLists23;

public class Main {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();

        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(4);
        h1.next.next = new ListNode(5);

        ListNode h2 = new ListNode(1);
        h2.next = new ListNode(3);
        h2.next.next = new ListNode(4);

        ListNode h3 = new ListNode(2);
        h3.next = new ListNode(6);

        ListNode head = solution.mergeKLists(new ListNode[]{h1, h2, h3});

        while (null != head) {
            System.out.println(head.val);
            head = head.next;
        }

    }
}
