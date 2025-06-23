/**
 * 328 Odd Even Linked List
 *
 * Medium
 *
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
 *
 * The first node is considered odd, and the second node is even, and so on.
 *
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 *
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 *
 * Example 2:
 *
 * Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
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
    println(oddEvenList(node1))
}

fun oddEvenList(head: ListNode?): ListNode? {
    var size = 1
    var current = head
    var tail: ListNode? = null

    // считаем длину списка
    while (current?.next != null) {
        size++
        current = current.next
        // определяем последний (хвостовой) элемент списка
        if (current?.next == null) tail = current
    }

    current = head

    // проходим по половине длины списка начиная с 1 (нечетного) узла
    for (i in 1..size / 2) {
        // при этом следующий (четный) узел temp добавляем к хвостовому узлу
        val even = current?.next
        tail?.next = even
        // temp ставим хвостовым узлом
        tail = tail?.next
        // сдвигаем указатель next на следующий нечетный узел тем самым удаляя четный узел
        current?.next = current?.next?.next
        current = current?.next
    }

    // у последнего хвостового узла зануляем ссылку на следующий узел
    tail?.next = null

    return head

}