public class Solution_206_ReverseLinkedList {
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
        System.out.println(reverseListIteratively(node1));
        System.out.println(reverseListRecursively(node1));
    }

    private static ListNode2 reverseListIteratively(ListNode2 head) {
        ListNode2 prev = null;
        var current = head;

        while (current != null) {
            var nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }

        return prev;
    }

    private static ListNode2 reverseListRecursively(ListNode2 head) {
        if (head == null || head.next == null) return head;

        var reversedList = reverseListRecursively(head.next);
        head.next.next = head;
        head.next = null;

        return reversedList;
    }
}

class ListNode2 {
    final int val;
    ListNode2 next = null;

    public ListNode2(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public ListNode2 getNext() {
        return next;
    }

    public void setNext(ListNode2 next) {
        this.next = next;
    }
}
