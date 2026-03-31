public class Solution_148_SortList {
    public static void main(String[] args) {
        var node1 = new ListNode2(-1);
        var node2 = new ListNode2(5);
        var node3 = new ListNode2(3);
        var node4 = new ListNode2(4);
        var node5 = new ListNode2(0);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        sortList(node1);
    }

    private static ListNode2 sortList(ListNode2 head) {
        if (head == null || head.next == null) return head;

        // 1. Найти середину
        var mid = getMid(head);
        var rightMid = mid.next;
        mid.next = null;

        // 2. Рекурсивная сортировка
        var left = sortList(head);
        var right = sortList(rightMid);

        // 3. Слияние
        return merge(left, right);
    }

    private static ListNode2 getMid(ListNode2 node) {
        var slow = node;
        var fast = node.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static ListNode2 merge(ListNode2 list1, ListNode2 list2) {
        var dummy = new ListNode2(0);
        var tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        tail.next = list1 != null ? list1 : list2;

        return dummy.next;
    }
}
