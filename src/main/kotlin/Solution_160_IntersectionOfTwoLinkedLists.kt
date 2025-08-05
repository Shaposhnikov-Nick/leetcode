/**
 * 160 Intersection of Two Linked Lists
 *
 * Easy
 *
 * Topics
 *
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 *
 * For example, the following two linked lists begin to intersect at node c1:
 *
 *
 * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 *
 * Note that the linked lists must retain their original structure after the function returns.
 *
 * Custom Judge:
 *
 * The inputs to the judge are given as follows (your program is not given these inputs):
 *
 * intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
 * listA - The first linked list.
 * listB - The second linked list.
 * skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
 * skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
 * The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.
 */
fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
    val node6 = ListNode(6)
    val node7 = ListNode(7)
    val node8 = ListNode(8)
    val node9 = ListNode(9)

    // list A
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    // list B
    node9.next = node8
    node8.next = node7
    node7.next = node6
    node6.next = node3
    node3.next = node4
    node5.next = node6

    getIntersectionNode(node1, node9)
}

/**
 * Пошаговое объяснение
 *
 * Инициализация указателей: Создаем два указателя, начинающиеся с головных узлов каждого списка.
 *
 * Цикл поиска пересечения: Пока указатели не равны (не указывают на один узел):
 *
 * Если pointerA достигает конца списка A, он переходит к началу списка B.
 *
 * Если pointerB достигает конца списка B, он переходит к началу списка A.
 *
 * Завершение цикла: Цикл завершится, когда:
 *
 * Оба указателя укажут на один узел (это узел пересечения)
 *
 * Оба указателя станут null (пересечения нет)
 *
 * Возврат результата: Возвращаем значение любого из указателей (они равны в этот момент)
 *
 * Временная и пространственная сложность
 * Временная сложность: O(m + n), где m и n - длины списков. Каждый указатель проходит оба списка.
 *
 * Пространственная сложность: O(1), используем только два указателя, константная память.
 */
fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    // Если один из списков пуст, пересечения нет
    if (headA == null || headB == null) return null

    var pointerA = headA
    var pointerB = headB

    // Продолжаем, пока указатели не станут равны
    while (pointerA != pointerB) {
        // Перемещаем указатели вперед
        pointerA = if (pointerA == null) headB else pointerA.next
        pointerB = if (pointerB == null) headA else pointerB.next
    }

    // Возвращаем либо узел пересечения, либо null
    return pointerA
}