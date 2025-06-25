/**
 * 19 Remove Nth Node From End of List
 *
 * Medium
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 *
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 */
fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
    val node6 = ListNode(6)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    println(removeNthFromEnd(node1, 2))
}

/**
 * Используем 2 указателя
 */
fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var fast = head
    var slow = head

    // смещаем fast на n позиций вперед
    for (i in 1..n) fast = fast?.next
    if (fast == null) return head?.next

    // когда fast будет на предпоследнем узле, slow будет перед тем узлом, который нужно удалить
    // т.к. fast - slow = n
    while (fast?.next != null) {
        fast = fast.next
        slow = slow?.next
    }

    // удаляем узел
    slow?.next = slow?.next?.next

    return head
}