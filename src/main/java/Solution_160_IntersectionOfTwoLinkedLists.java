public class Solution_160_IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        var node1 = new ListNode2(1);
        var node2 = new ListNode2(2);
        var node3 = new ListNode2(3);
        var node4 = new ListNode2(4);
        var node5 = new ListNode2(5);
        var node6 = new ListNode2(6);
        var node7 = new ListNode2(7);
        var node8 = new ListNode2(8);

        // list A
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        // list B
        node8.setNext(node7);
        node7.setNext(node4);
        node4.setNext(node5);

        getIntersectionNode(node1, node8);
    }

    private static ListNode2 getIntersectionNode(ListNode2 headA, ListNode2 headB) {
        if (headA == null || headB == null) return null;

        var pointerA = headA;
        var pointerB = headB;

        while (pointerA != pointerB) {
            pointerA = pointerA == null ? headB : pointerA.next;
            pointerB = pointerB == null ? headA : pointerB.next;
        }

        return pointerA;
    }
}
