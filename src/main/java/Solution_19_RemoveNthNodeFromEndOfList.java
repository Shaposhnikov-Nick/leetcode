public class Solution_19_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        var node1 = new ListNode2(1);
        var node2 = new ListNode2(2);
        var node3 = new ListNode2(3);
        var node4 = new ListNode2(4);
        var node5 = new ListNode2(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        System.out.println(removeNthFromEnd(node1, 2));
    }

    private static ListNode2 removeNthFromEnd(ListNode2 head, int n) {
        var fast = head;
        var slow = head;

        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        if (fast == null) return head.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
