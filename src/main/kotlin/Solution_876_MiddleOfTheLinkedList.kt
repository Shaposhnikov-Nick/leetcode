/**
 * 876 Middle of the Linked List
 *
 * Easy
 *
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 100].
 * 1 <= Node.val <= 100
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

    middleNode(node1)
}

/**
 * Итеративный метод:
 *
 * - считаем количество нод в списке
 * - находим середину
 * - итерируемся до середины, начиная с 0
 * - возвращаем указатель на среднюю ноду
 */
fun middleNode(head: ListNode?): ListNode? {
    var length = 0
    var current = head

    // считаем количество нод в списке
    while (current != null) {
        length++
        current = current.next
    }

    // находим середину
    val mid = length / 2

    // итерируемся до середины, начиная с 0
    current = head
    var i = 0
    while (i <= mid) {
        current = current?.next
        i++
    }

    // возвращаем указатель на среднюю ноду
    return current
}

/**
 * Метод медленного и бытсрого указателя для поиска середины связного списка
 *
 * - меделнный переходит на каждый следующий элемент списка
 * - быстрый переходит через 1 элемент списка
 * - когда быстрый будет в конце, медленный будет в середине списка
 */
fun middleNode2(head: ListNode?): ListNode? {
    var fast = head
    var slow = head

    while (fast != null && fast.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    return slow
}