/**
 * 203 Remove Linked List Elements
 *
 * Easy
 *
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 * Example 2:
 *
 * Input: head = [], val = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [7,7,7,7], val = 7
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 104].
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 */
fun main() {
    val node1 = ListNode(5)
    val node2 = ListNode(4)
    val node3 = ListNode(3)
    val node4 = ListNode(2)
    val node5 = ListNode(1)
    val node6 = ListNode(1)
//    val node7 = ListNode(6)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
//    node6.next = node7

    val `val` = 1

    removeElements(node1, `val`)
}

/**
 * Создаем отдельный список dummy для хранения подходящих узлов. dummyCurrent указывает на последний узел в этом списке
 * Проходим по списку head, проверяя значения каждого узла. Если значение не равно `val`, добавляем его в список dummy.
 */
fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    var current = head
    // Создаем отдельный список dummy для хранения подходящих узлов
    val dummy = ListNode(-1)
    // указывает на последний узел в этом списке
    var dummyCurrent: ListNode? = dummy

    // Проходим по списку head
    while (current != null) {
        // Если значение не равно `val`, добавляем его в список dummy
        if (current.`val` != `val`) {
            dummyCurrent?.next = ListNode(current.`val`)
            // двигаем указатель dummyCurrent на последний узел
            dummyCurrent = dummyCurrent?.next
        }

        // двигаем указатель current на следующий узел
        current = current.next
    }

    return dummy.next
}

fun removeElements2(head: ListNode?, `val`: Int): ListNode? {
    if (head == null) return null
    val dummy = ListNode(0)
    dummy.next = head

    var prev = dummy
    var curr = head

    while (curr != null) {
        if (curr.`val` == `val`) {
            prev.next = curr.next
        } else {
            prev = curr
        }
        curr = curr.next
    }
    return dummy.next
}