public class Solution_21_MergeTwoSortedLinkedLists {
    public static void main(String[] args) {
        var node1 = new ListNode2(1);
        var node2 = new ListNode2(2);
        var node3 = new ListNode2(4);
        node1.setNext(node2);
        node2.setNext(node3);

        var node4 = new ListNode2(1);
        var node5 = new ListNode2(3);
        var node6 = new ListNode2(4);
        node4.setNext(node5);
        node5.setNext(node6);
        System.out.println(mergeTwoLists(node1, node4));
    }

    private static ListNode2 mergeTwoLists(ListNode2 list1, ListNode2 list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        var mergedHead = new ListNode2(0);
        var current = mergedHead;
        var currentList1 = list1;
        var currentList2 = list2;

        while (currentList1 != null && currentList2 != null) {
            if (currentList1.val <= currentList2.val) {
                current.next = currentList1;
                currentList1 = currentList1.next;
            } else {
                current.next = currentList2;
                currentList2 = currentList2.next;
            }
            current = current.next;
        }

        if (currentList1 != null) current.next = currentList1;
        else current.next = currentList2;

        return mergedHead.next;
    }
}
