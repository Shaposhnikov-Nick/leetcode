/**
 * Given the head of a linked list, return the list after sorting it in ascending order.

 *
 * Example 1:
 *
 *
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * Example 2:
 *
 *
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 5 * 104].
 * -105 <= Node.val <= 105
 *
 */
fun main() {
    val node1 = ListNode(-1)
    val node2 = ListNode(5)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(0)
    val node6 = ListNode(6)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    sortList(node1)
}

/**
 * Merge Sort (сортировка слиянием)
 * Идея решения
 * Разделить список на 2 половины (через slow/fast указатели)
 * Рекурсивно отсортировать обе части
 * Слить два отсортированных списка
 *
 * Сложность
 * Время: O(n log n)
 * Память: O(log n) (из-за рекурсии)
 */
fun sortList(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    // 1. Делим список пополам
    val mid = getMid(head)
    val rightHead = mid.next
    // Чтобы разорвать список на два отдельных списка, иначе будет зацикливание
    mid.next = null

    // 2. Рекурсивно сортируем
    val left = sortList(head)
    val right = sortList(rightHead)

    // 3. Сливаем
    return merge(left, right)
}

/**
 * 1. Как найти середину?
 * var slow = head
 * var fast = head.next
 * slow идёт на 1 шаг
 * fast на 2 шага
 * ➡️ когда fast дошёл до конца — slow в середине
 */
private fun getMid(head: ListNode): ListNode {
    var slow = head
    var fast = head.next

    while (fast != null && fast.next != null) {
        slow = slow.next!!
        fast = fast.next?.next
    }

    return slow
}

private fun merge(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var tail = dummy

    var left = l1
    var right = l2

    while (left != null && right != null) {
        if (left.`val` < right.`val`) {
            tail.next = left
            left = left.next
        } else {
            tail.next = right
            right = right.next
        }
        tail = tail.next!!
    }

    tail.next = left ?: right

    return dummy.next
}