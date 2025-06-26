/**
 * 2 Add Two Numbers
 *
 * Medium
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    node1.next = node2
    node2.next = node3

    val node4 = ListNode(4)
    val node5 = ListNode(5)
    val node6 = ListNode(5)
    node4.next = node5
    node5.next = node6
    println(addTwoNumbers(node1, node4))
}

/**
 * Объяснение:
 * Инициализация переменных:
 *
 * node1 и node2 — указатели на текущие узлы списков l1 и l2.
 *
 * dummyHead — фиктивный узел, который поможет легко вернуть начало результирующего списка.
 *
 * current — указатель на текущий узел результирующего списка.
 *
 * carry — переменная для хранения переноса (если сумма цифр >= 10).
 *
 * Цикл while:
 *
 * Продолжается, пока есть узлы в l1 или l2, или есть перенос (carry != 0).
 *
 * На каждой итерации:
 *
 * Берем значения текущих узлов (или 0, если узел null).
 *
 * Считаем сумму значений и переноса.
 *
 * Определяем новый перенос и значение для нового узла.
 *
 * Создаем новый узел и двигаем указатель current.
 *
 * Переходим к следующим узлам в l1 и l2, если они есть.
 *
 * Возврат результата:
 *
 * Возвращаем dummyHead.next, так как dummyHead — фиктивный узел, а первый реальный узел результирующего списка — это его next.
 *
 * Это решение эффективно и работает за время O(max(n, m)), где n и m — длины списков l1 и l2.
 */
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var node1 = l1
    var node2 = l2
    val dummyHead = ListNode(0)
    var current: ListNode? = dummyHead
    var carry = 0

    while (node1 != null || node2 != null || carry != 0) {
        val val1 = node1?.`val` ?: 0
        val val2 = node2?.`val` ?: 0
        val sum = val1 + val2 + carry
        carry = sum / 10
        current?.next = ListNode(sum % 10)

        current = current?.next
        node1 = node1?.next
        node2 = node2?.next
    }

    return dummyHead.next
}