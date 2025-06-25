/**
 * 21 Merge Two Sorted Lists
 *
 * Easy
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 * Example 1:
 *
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Example 2:
 *
 * Input: list1 = [], list2 = []
 * Output: []
 *
 * Example 3:
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 */
fun main() {
    // first list
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(4)
    node1.next = node2
    node2.next = node3

    // second list
    val node4 = ListNode(1)
    val node5 = ListNode(3)
    val node6 = ListNode(4)
    node4.next = node5
    node5.next = node6

    println(mergeTwoLists(node1, node4))
}

/**
 * 2 указателя
 */
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) return list2
    if (list2 == null) return list1
    // голова нового списка
    val mergedHead = ListNode(0)
    // указатель в новом списке
    var current: ListNode? = mergedHead
    // указатель на list1
    var currentList1 = list1
    // указатель на list2
    var currentList2 = list2

    // двигаем указатели по списку
    while (currentList1 != null && currentList2 != null) {
        // если значение в list1 меньше чем в list2
        if (currentList1.`val` <= currentList2.`val`) {
            // добавляем этот узел из list1 в новый список
            current?.next = currentList1
            // двигаем указатель list1 к следующему узлу
            currentList1 = currentList1.next
        } else {
            // добавляем этот узел из list2 в новый список
            current?.next = currentList2
            // двигаем указатель list2 к следующему узлу
            currentList2 = currentList2.next
        }
        // сдвигаем указатель в новом писке
        current = current?.next
    }

    // когда дошли до конца, добавляем последний элемент к концу (тот, который не null)
    current?.next = currentList1 ?: currentList2

    return mergedHead.next
}