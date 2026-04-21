public class Solution_61_RotateList {
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

        int k = 2_000_000_003;

        rotateRight(node1, k);
    }

    /**
     * Для удобства вставки узла из конца в начало используем dummy head
     * Определим размер списка
     * Вычислим, сколько на самом деле нужно сделать итераций по перемещению конечного узла в начало:
     * учитываем, что каждые size раз итераций список просто развернется в обратную сторону,
     * и что 2 * size раз итераций список будет таким же как в начале.
     * Поэтому если k больше чем 2 * size, найдем нужное количество итераций как остаток от деления.
     * <p>
     * Доходим до предпоследнего узла
     * Чтобы последний узел стал первым, добавляем ему ссылку на реальный первый узел
     * Фиктивная голова должна ссылаться на новый реальный первый узел
     * Чтобы избежать зацикливания, у нового последнего узла зануляем ссылку на следующий узел
     */
    private static ListNode2 rotateRight(ListNode2 head, int k) {
        if (head == null || head.next == null) return head;
        // Первый реальный узел в списке
        var firstNode = head;
        // Для удобства вставки узла из конца в начало используем dummy head
        var dummy = new ListNode2(-200);
        dummy.next = head;

        // Определим размер списка
        var size = 1;
        var curr = head;
        while (curr.next != null) {
            size++;
            curr = curr.next;
        }

        // Вычислим, сколько на самом деле нужно сделать итераций по перемещению конечного узла в начало:
        // учитываем, что каждые size раз итераций список просто развернется в обратную сторону,
        // и что 2 * size раз итераций список будет таким же как в начале.
        // Поэтому если k больше чем 2 * size, найдем нужное количество итераций как остаток от деления.
        var n = k;
        if (k > 2 * size) n = k % (2 * size);

        for (int i = 0; i < n; i++) {
            var current = dummy;
            // Доходим до предпоследнего узла
            while (current.next != null && current.next.next != null) {
                current = current.next;
            }
            var last = current.next;
            // Чтобы последний узел стал первым, добавляем ему ссылку на реальный первый узел
            last.next = firstNode;
            // Фиктивная голова теперь должна ссылаться на новый реальный первый узел
            dummy.next = last;
            // Чтобы избежать зацикливания, у нового последнего узла зануляем ссылку на следующий узел
            current.next = null;
            // Обновляем ссылку на реальный первый узел
            firstNode = dummy.next;
        }

        return firstNode;
    }
}
