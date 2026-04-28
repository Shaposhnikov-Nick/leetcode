/**
 * 86  Partition List
 *
 * Medium
 *
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 * Example 2:
 *
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 200].
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */
fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    val x = 3

    partition(node1, x)
}

/**
 * Создадим два связных списка для узлов, значение которых меньше x, и узлов, значение которых больше x
 * Проходим по всему связному списку и сравниваем значение узлов,  добавляя их в соответствующие списки
 * Когда доходим до конца основного списка, добавляем список afterHead к концу списка beforeHead,
 * а у списка afterHead зануляем последнюю next ссылку, чтобы избежать зацикливания
 */
fun partition(head: ListNode?, x: Int): ListNode? {
    // Создадим два связных списка для узлов, значение которых меньше x, и узлов, значение которых больше x
    val beforeHead = ListNode(-200)
    val afterHead = ListNode(-200)

    // указатель основного списка
    var current = head
    // указатель списка узлов, значение которых меньше x
    var beforeCurrent: ListNode? = beforeHead
    // указатель списка узлов, значение которых больше x
    var afterCurrent: ListNode? = afterHead

    // Проходим по всему связному списку и сравниваем значение узлов,  добавляя их в соответствующие списки
    while (current != null) {
        if (current.`val` < x) {
            beforeCurrent!!.next = current
            beforeCurrent = beforeCurrent.next
        } else {
            afterCurrent!!.next = current
            afterCurrent = afterCurrent.next
        }

        current = current.next

        // Когда доходим до конца основного списка, добавляем список afterHead к концу списка beforeHead,
        // а у списка afterHead зануляем последнюю next ссылку, чтобы избежать зацикливания
        if (current == null) {
            beforeCurrent!!.next = afterHead.next
            afterCurrent!!.next = null
        }
    }

    return beforeHead.next
}