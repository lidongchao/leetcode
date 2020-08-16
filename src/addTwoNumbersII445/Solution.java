package addTwoNumbersII445;

import utils.ListNode;

import java.util.Stack;

/**
 * 思路 1：栈
 *
 * 执行用时 :5 ms, 在所有 Java 提交中击败了59.59%的用户
 * 内存消耗 :40.3 MB, 在所有 Java 提交中击败了95.83%的用户
 */
class Solution {
    /**
     * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     *
     * 进阶：
     * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 相加后的链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);

        // 将两个链表的数据存储在栈中
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (null != l1) {
            s1.add(l1.val);
            l1 = l1.next;
        }
        while (null != l2) {
            s2.add(l2.val);
            l2 = l2.next;
        }
        // 数据出栈，相加后放入新的链表中
        int carry = 0;
        while (!s1.empty() && !s2.empty()) {
            int v = s1.pop() + s2.pop() + carry;
            carry = addNode(head, v);
        }
        while (!s1.empty()) {
            int v = s1.pop() + carry;
            carry = addNode(head, v);
        }
        while (!s2.empty()) {
            int v = s2.pop() + carry;
            carry = addNode(head, v);
        }
        if (0 != carry) {
            addNode(head, carry);
        }

        // 返回新的链表
        return head.next;
    }

    // 头插法添加新结点，返回是否进位
    private int addNode(ListNode head, int val) {
        ListNode node;
        int carry;
        if (val > 9) {
            node = new ListNode(val - 10);
            carry = 1;
        } else {
            node = new ListNode(val);
            carry = 0;
        }
        node.next = head.next;
        head.next = node;
        return carry;
    }

}
