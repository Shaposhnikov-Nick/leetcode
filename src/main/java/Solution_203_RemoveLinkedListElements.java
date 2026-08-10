public class Solution_203_RemoveLinkedListElements {
    public static void main(String[] args) {
        var node1 = new ListNode2(1);
        var node2 = new ListNode2(2);
        var node3 = new ListNode2(6);
        var node4 = new ListNode2(3);
        var node5 = new ListNode2(4);
        var node6 = new ListNode2(5);
        var node7 = new ListNode2(6);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);

        var val = 6;

        removeElements(node1, val);
    }

    /**
     * Создаем отдельный список dummy для хранения подходящих узлов.
     * Создаем два указателя current - текущий узел в head, prev - последний похоядщий узел в списке dummy (по сути
     * это предыдущий для current)
     * Проходим по списку head
     * Если значение текущего узла равно val, исключаем этот узел, иначе двигаем указатель prev на следующий узел
     */
    private static ListNode2 removeElements(ListNode2 head, int val) {
        // Создаем отдельный список dummy для хранения подходящих узлов
        var dummy = new ListNode2(-1);
        dummy.next = head;

        // Создаем два указателя
        // current - текущий узел в head
        var current = head;
        // prev - последний похоядщий узел в списке dummy (по сути это предыдущий для current)
        var prev = dummy;

        // Проходим по списку head
        while (current != null) {
            // Если значение текущего узла равно val
            if (current.val == val) {
                // исключаем этот узел
                prev.next = current.next;
            } else {
                // иначе двигаем указатель prev на следующий узел
                prev = current;
            }
            // двигаем указатель current
            current = current.next;
        }

        return dummy.next;
    }
}
