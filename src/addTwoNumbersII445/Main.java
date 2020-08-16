package addTwoNumbersII445;

import utils.AssertUtils;
import utils.ListNode;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 7243
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        // 564
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // 7807
        ListNode ans1 = solution.addTwoNumbers(l1, l2);
        AssertUtils.assertEqualsInteger(7, ans1.val);
        AssertUtils.assertEqualsInteger(8, ans1.next.val);
        AssertUtils.assertEqualsInteger(0, ans1.next.next.val);
        AssertUtils.assertEqualsInteger(7, ans1.next.next.next.val);

    }
}
