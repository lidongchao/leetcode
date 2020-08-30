package middleOfTheLinkedList876;

import utils.AssertUtils;
import utils.ListNode;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        int[] arr_1 = {1,2,3,4,5};
        int expect_1 = 3;
        AssertUtils.assertEquals(expect_1, solution.middleNode(generateList(arr_1)).val);

        int[] arr_2 = {1,2,3,4,5,6};
        int expect_2 = 4;
        AssertUtils.assertEquals(expect_2, solution.middleNode(generateList(arr_2)).val);

    }

    private static ListNode generateList(int[] arr) {
        if (0 == arr.length) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode p = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode next = new ListNode(arr[i]);
            p.next = next;
            p = next;
        }
        return head;
    }

}
