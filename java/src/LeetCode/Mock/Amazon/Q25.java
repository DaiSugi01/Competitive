package LeetCode.Mock.Amazon;

public class Q25 {
    public static void main(String[] args) {
        Q25 sol = new Q25();

        ListNode l1 = new Q25.ListNode(2);
        l1.next = new Q25.ListNode(4);
        l1.next.next = new Q25.ListNode(3);

        ListNode l2 = new Q25.ListNode(5);
        l2.next = new Q25.ListNode(6);
        l2.next.next = new Q25.ListNode(4);
        sol.addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum1 = 0;
        while (l1 != null) {
            sum1 = sum1 * 10 + l1.val;
            l1 = l1.next;
        }

        int sum2 = 0;
        while (l2 != null) {
            sum2 = sum2 * 10 + l2.val;
            l2 = l2.next;
        }

        int sum = sum1 + sum2;
        ListNode ans = new ListNode(sum % 10);
        sum /= 10;
        ListNode p = ans;
        while (sum > 0) {
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = p;
            p = newNode;
            sum /= 10;
        }

        return p;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
