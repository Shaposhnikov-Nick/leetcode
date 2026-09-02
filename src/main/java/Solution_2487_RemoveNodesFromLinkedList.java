import java.util.ArrayDeque;

public class Solution_2487_RemoveNodesFromLinkedList {
    public static void main(String[] args) {
        var node1 = new ListNode2(5);
        var node2 = new ListNode2(2);
        var node3 = new ListNode2(13);
        var node4 = new ListNode2(3);
        var node5 = new ListNode2(8);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        removeNodes(node1);
    }

    /**
     * Решение с использованием стека
     * <p>
     * Складываем значения узлов в стек
     * Если значение больше, чем те, что лежат в стеке, удаляем их
     * Строим новый список из оставшихся в стеке значений
     */
    private static ListNode2 removeNodes(ListNode2 head) {
        var stack = new ArrayDeque<Integer>();
        var current = head;

        // Собираем все значения в стек
        while (current != null) {
            // Удаляем из стека все меньшие значения
            while (!stack.isEmpty() && stack.getLast() < current.val) {
                stack.removeLast();
            }

            stack.addLast(current.val);
            current = current.next;
        }

        var dummy = new ListNode2(-1);
        current = dummy;

        // Строим новый список из стека
        while (!stack.isEmpty()) {
            current.next = new ListNode2(stack.removeFirst());
            current = current.next;
        }

        return dummy.next;
    }
}
