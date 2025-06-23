public class Solution_328_OddEvenLinkedList {
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
        System.out.println(oddEvenList(node1));
    }

    private static ListNode2 oddEvenList(ListNode2 head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode2 odd = head;
        ListNode2 even = head.next;
        ListNode2 evenHead = even; // сохраняем начало чётного списка

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead; // соединяем нечётный список с чётным
        return head;
    }
}
