fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    println(reverseListIteratively(node1))
    println(reverseListRecursively(node1))
}

/**
 * iteratively
 */
fun reverseListIteratively(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var current = head
    while (current != null) {
        val nextTemp = current.next
        current.next = prev
        prev = current
        current = nextTemp
    }
    return prev
}

/**
 * Recursively
 *
 * Рекурсия идет до конца списка, пока не достигнет последнего узла (это будет новый головной узел после разворота).
 *
 * На каждом шаге возврата из рекурсии:
 *
 * Текущий узел head становится следующим для своего бывшего следующего узла (head.next.next = head).
 *
 * Ссылка next текущего узла устанавливается в null (чтобы избежать циклов).
 *
 * В конце возвращается новый головной узел (бывший последний узел исходного списка).
 *
 * Пример работы:
 * Исходный список: 1 → 2 → 3 → 4 → 5
 * Развернутый список: 5 → 4 → 3 → 2 → 1
 *
 * Сложность этого решения: O(n) по времени и O(n) по памяти (из-за стека рекурсивных вызовов).
 */
fun reverseListRecursively(head: ListNode?): ListNode? {
    // Базовый случай рекурсии: если список пуст или содержит один элемент
    if (head?.next == null) return head

    // Рекурсивно разворачиваем остаток списка
    val reversedList = reverseListRecursively(head.next)

    // Переворачиваем ссылки
    head.next?.next = head
    head.next = null

    // Возвращаем новый головной узел
    return reversedList
}


class ListNode(val value: Int) {
    var next: ListNode? = null
}