fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(1)
    val node3 = ListNode(1)
    val node4 = ListNode(2)
    val node5 = ListNode(3)
//    val node6 = ListNode(4)
//    val node7 = ListNode(5)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
//    node5.next = node6
//    node6.next = node7
    deleteDuplicatesII(node1)
}

/**
 * Добавляем перед head фиктивный узел dummy, он по умолчанию будет первым уникальным узлом (если,
 * например, настоящие первые узлы окажутся дубликатами).
 *
 * В цикле начиная с head проверяем каждый узел и сравниваем его значение со следующим узлом.
 *
 * Если следующий узел имеет другое значенние, отмечаем текущий как lastUniqueNode и сдвигаем указатель current
 * на следующий узел.
 *
 * Если следующий узел имеет такое же значение, в другом цикле ищем, сколько подряд этих совпадений.
 * У lastUniqueNode добавляем следующим элементом другой уникальный узел, минуя дубликаты и сдвигм указатель current
 *  * наа следующий узел.
 *
 * Возвращаем dummy?.next
 */
fun deleteDuplicatesII(head: ListNode?): ListNode? {
    // Добавляем перед head фиктивный узел dummy, он по умолчанию будет первым уникальным узлом (если,
    // например, настоящие первые узлы окажутся дубликатами).
    val dummy: ListNode? = ListNode(-200)
    dummy?.next = head
    var current = head
    var lastUniqueNode: ListNode? = null

    // В цикле начиная с head проверяем каждый узел и сравниваем его значение со следующим узлом.
    while (current != null) {
        // Если следующий узел имеет другое значенние, отмечаем текущий как lastUniqueNode и сдвигаем указатель current
        // на следующий узел.
        if (current.`val` != current.next?.`val`) {
            lastUniqueNode = current
            current = current.next
        } else {
            // Если следующий узел имеет такое же значение, в другом цикле ищем, сколько подряд этих совпадений.
            // У lastUniqueNode добавляем следующим элементом другой уникальный узел, минуя дубликаты и сдвигм указатель current
            // наа следующий узел.
            var toRemove = current
            while (toRemove?.`val` == toRemove?.next?.`val`) {
                toRemove = toRemove?.next
            }
            if (lastUniqueNode == null) {
                lastUniqueNode = dummy
            }
            lastUniqueNode?.next = toRemove?.next
            current = toRemove?.next
        }
    }

    return dummy?.next
}