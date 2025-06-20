public class Solution_2095_DeleteMiddleNodeOfLinkedList {
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
        System.out.println(deleteMiddle(node1));
    }

    private static ListNode2 deleteMiddle(ListNode2 head) {
        if (head.next == null) return null;

        var dummyHead = new ListNode2(0);
        dummyHead.next = head;
        var slow = dummyHead;
        var fast = dummyHead;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
