public class Solution_2_AddTwoNumbers {
    public static void main(String[] args) {
        var node1 = new ListNode2(1);
        var node2 = new ListNode2(2);
        var node3 = new ListNode2(3);
        node1.setNext(node2);
        node2.setNext(node3);

        var node4 = new ListNode2(4);
        var node5 = new ListNode2(5);
        var node6 = new ListNode2(6);
        node4.setNext(node5);
        node5.setNext(node6);

        System.out.println(addTwoNumbers(node1, node4));
    }

    private static ListNode2 addTwoNumbers(ListNode2 l1, ListNode2 l2) {
        var node1 = l1;
        var node2 = l2;
        var dummyHead = new ListNode2(0);
        var current = dummyHead;
        var carry = 0;

        while (node1 != null || node2 != null || carry != 0) {
            var val1 = 0;
            var val2 = 0;
            if (node1 != null) val1 = node1.getVal();
            if (node2 != null) val2 = node2.getVal();
            var sum = val1 + val2 + carry;
            carry = sum / 10;

            current.next = new ListNode2(sum % 10);
            current = current.next;

            if (node1 != null && node1.next != null) node1 = node1.next;
            else node1 = null;

            if (node2 != null && node2.next != null) node2 = node2.next;
            else node2 = null;
        }

        return dummyHead.next;
    }
}
