public class Solution_86_PartitionList {

    public static void main(String[] args) {
        var node1 = new ListNode2(1);
        var node2 = new ListNode2(4);
        var node3 = new ListNode2(3);
        var node4 = new ListNode2(2);
        var node5 = new ListNode2(5);
        var node6 = new ListNode2(2);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        var x = 2;

        partition(node1, x);
    }

    /**
     * Создадим два связных списка для узлов, значение которых меньше x, и узлов, значение которых больше x
     * Проходим по всему связному списку и сравниваем значение узлов,  добавляя их в соответствующие списки
     * Когда доходим до конца основного списка, добавляем список afterHead к концу списка beforeHead,
     * а у списка afterHead зануляем последнюю next ссылку, чтобы избежать зацикливания
     */
    private static ListNode2 partition(ListNode2 head, int x) {
        // Создадим два связных списка для узлов, значение которых меньше x, и узлов, значение которых больше x
        var beforeHead = new ListNode2(-200);
        var afterHead = new ListNode2(-200);

        // указатель основного списка
        var current = head;
        // указатель списка узлов, значение которых меньше x
        var beforeCurrent = beforeHead;
        // указатель списка узлов, значение которых больше x
        var afterCurrent = afterHead;

        // Проходим по всему связному списку и сравниваем значение узлов,  добавляя их в соответствующие списки
        while (current != null) {
            if (current.val < x) {
                beforeCurrent.next = current;
                beforeCurrent = beforeCurrent.next;
            } else {
                afterCurrent.next = current;
                afterCurrent = afterCurrent.next;
            }

            current = current.next;

            // Когда доходим до конца основного списка, добавляем список afterHead к концу списка beforeHead,
            // а у списка afterHead зануляем последнюю next ссылку, чтобы избежать зацикливания
            if (current == null) {
                beforeCurrent.next = afterHead.next;
                afterCurrent.next = null;
            }
        }

        return beforeHead.next;
    }
}
