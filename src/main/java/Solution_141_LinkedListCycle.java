public class Solution_141_LinkedListCycle {
    public static void main(String[] args) {
        var node1 = new ListNode2(1);
        var node2 = new ListNode2(2);
        var node3 = new ListNode2(3);
        var node4 = new ListNode2(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node4.setNext(node2);
        System.out.println(hasCycle(node1));
    }

    private static boolean hasCycle(ListNode2 head) {
        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;
    }
}
