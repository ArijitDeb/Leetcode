package problems;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * 2. Add Two Numbers
 * <p>Medium
 *
 * <p>You are given two non-empty linked lists representing two non-negative integers. The digits
 * are stored in reverse order and each of their nodes contain a single digit. Add the two numbers
 * and return it as a linked list.
 *
 * <p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * <p>Example:
 *
 * <p>Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode();
        ListNode dummyHead = head;

        while (l1 != null || l2 != null) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            if (sum / 10 > 0) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            ListNode newNode = new ListNode(sum);
            head.next = newNode;
            head = newNode;
        }

        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            head.next = newNode;
        }

        return dummyHead.next;
    }
}
