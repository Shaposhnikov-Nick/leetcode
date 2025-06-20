/**
 * 2095 Delete the Middle Node of a Linked List
 *
 * You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
 *
 * The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.
 *
 * For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
 *
 * Example 1:
 *
 * Input: head = [1,3,4,7,1,2,6]
 * Output: [1,3,4,1,2,6]
 * Explanation:
 * The above figure represents the given linked list. The indices of the nodes are written below.
 * Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
 * We return the new list after removing this node.
 *
 * Example 2:
 *
 * Input: head = [1,2,3,4]
 * Output: [1,2,4]
 * Explanation:
 * The above figure represents the given linked list.
 * For n = 4, node 2 with value 3 is the middle node, which is marked in red.
 *
 * Example 3:
 *
 *
 * Input: head = [2,1]
 * Output: [2]
 * Explanation:
 * The above figure represents the given linked list.
 * For n = 2, node 1 with value 1 is the middle node, which is marked in red.
 * Node 0 with value 2 is the only node remaining after removing node 1.
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 105].
 * 1 <= Node.val <= 10^5
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

    println(deleteMiddle(node1))
}

/**
 * Быстрый и медленный указатели
 */
fun deleteMiddle(head: ListNode?): ListNode? {
    if (head?.next == null) return null

    // Создаем фиктивный головной элемент
    val dummyHead = ListNode(0)
    dummyHead.next = head

    // Создаем быстрый и медленный указатели, начиная с фиктивного
    var slow: ListNode? = dummyHead
    var fast: ListNode? = dummyHead

    // Когда быстрый указатель будет перед концом списка, медленный будет перед средним элементом (т.к. отсчет начался с dummyHead)
    while (fast?.next?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    // меняем ссылку на next на элемент, находящийся после среднего
    slow?.next = slow?.next?.next

    return head
}

/**
 * Итераитивный подсчет количества элементов в списке
 */
fun deleteMiddle2(head: ListNode?): ListNode? {
    // Find length of the linked list
    var length = 0
    var tempHead = head
    var currentNode = head
    var prevNode: ListNode? = null

    // Race Condition: If the head is null or has only one node, return null or the head respectively
    if (tempHead == null) {
        return null
    }

    // Race Condition: If the head has only one node, return null
    if (tempHead.next == null) {
        return null
    }

    // Calculate the length of the linked list
    while (tempHead != null) {
        length++
        tempHead = tempHead.next
    }

    val middleIndex = length / 2


    // Step 2: Traverse to the node before middle
    for (i in 0..middleIndex) {
        if (i == middleIndex) {
            prevNode?.next = currentNode?.next
        } else {
            prevNode = currentNode
            currentNode = currentNode?.next
        }
    }
    return head
}