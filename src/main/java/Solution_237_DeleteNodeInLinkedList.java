public class Solution_237_DeleteNodeInLinkedList {
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
        deleteNode(node3);
    }

    private static void deleteNode(ListNode2 node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
