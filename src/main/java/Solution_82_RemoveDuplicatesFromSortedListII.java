public class Solution_82_RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        var node1 = new ListNode2(1);
        var node2 = new ListNode2(2);
        var node3 = new ListNode2(3);
        var node4 = new ListNode2(3);
        var node5 = new ListNode2(4);
        var node6 = new ListNode2(4);
        var node7 = new ListNode2(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        deleteDuplicates(node1);
    }

    private static ListNode2 deleteDuplicates(ListNode2 head) {
        // Добавляем перед head фиктивный узел dummy, он по умолчанию будет первым уникальным узлом (если,
        // например, настоящие первые узлы окажутся дубликатами).
        var dummy = new ListNode2(-200);
        dummy.next = head;
        var current = head;
        ListNode2 lastUniqueNode = null;

        // В цикле начиная с head проверяем каждый узел и сравниваем его значение со следующим узлом.
        while (current != null && current.next != null) {
            // Если следующий узел имеет другое значенние, отмечаем текущий как lastUniqueNode и сдвигаем указатель current
            // на следующий узел.
            if (current.val != current.next.val) {
                lastUniqueNode = current;
                current = current.next;
            } else {
                // Если следующий узел имеет такое же значение, в другом цикле ищем, сколько подряд этих совпадений.
                // У lastUniqueNode добавляем следующим элементом другой уникальный узел, минуя дубликаты и сдвигм указатель current
                // наа следующий узел.
                var toRemove = current;

                while (toRemove.next != null && toRemove.val == toRemove.next.val) {
                    toRemove = toRemove.next;
                }

                if (lastUniqueNode == null) {
                    lastUniqueNode = dummy;
                }

                lastUniqueNode.next = toRemove.next;
                current = toRemove.next;
            }
        }

        return dummy.next;
    }
}
