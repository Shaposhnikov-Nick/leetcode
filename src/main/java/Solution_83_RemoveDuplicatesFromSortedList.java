public class Solution_83_RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        var node1 = new ListNode2(1);
        var node2 = new ListNode2(1);
        var node3 = new ListNode2(2);
        var node4 = new ListNode2(3);
        var node5 = new ListNode2(3);
        var node6 = new ListNode2(4);
        var node7 = new ListNode2(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        deleteDuplicates(node1);
    }

    private static ListNode2 deleteDuplicates(ListNode2 head) {
        var current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}
