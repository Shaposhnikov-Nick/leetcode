/**
 * 83 Remove Duplicates from Sorted List
 *
 * Easy
 *
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,1,2]
 * Output: [1,2]
 * Example 2:
 *
 *
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(1)
    val node3 = ListNode(2)
    val node4 = ListNode(3)
    val node5 = ListNode(3)
    val node6 = ListNode(4)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    deleteDuplicates(node1)
}

/**
 * Проходим по отсортированному списку
 * Проверяем значение следующего узла
 * Если занчение текущего узла равно значению следующего, изменяем у текущего узла сслыку на второй после следущего узел
 * Иначе проверяем следующий узел
 */
fun deleteDuplicates(head: ListNode?): ListNode? {
    var current = head
    // Проходим по отсортированному списку
    while (current != null) {
        // Проверяем значение следующего узла
        val next = current.next
        // Если занчение текущего узла равно значению следующего,
        // изменяем у текущего узла сслыку на второй после следущего узел
        if (current.`val` == next?.`val`) {
            current.next = next.next
        } else {
            // Иначе проверяем следующий узел
            current = next
        }
    }

    return head
}