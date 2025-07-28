import kotlin.math.max

/**
 * 2130 Maximum Twin Sum of a Linked List
 *
 * Medium
 *
 * In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
 *
 * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
 * The twin sum is defined as the sum of a node and its twin.
 *
 * Given the head of a linked list with even length, return the maximum twin sum of the linked list.
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
    println(pairSum(node1))
}

/**
 * 1 Найдем длину связанного списка.
 * 2 Сохраним значения узлов в список (например, ArrayList).
 * 3 Пройдемся по первой половине узлов и вычислим суммы с их твинами из второй половины.
 * 4 Найдем и вернем максимальную сумму.
 */
fun pairSum(head: ListNode?): Int {
    val values = mutableListOf<Int>()
    var current = head

    while (current != null) {
        values.add(current.`val`)
        current = current.next
    }

    var maxSum = 0
    val n = values.size

    for (i in 0 until n / 2) {
        val twinIndex = n - 1 - i
        val sum = values[i] + values[twinIndex]
        maxSum = max(maxSum, sum)
    }

    return maxSum
}

/**
 * Нахождение середины списка: Используем два указателя - медленный (двигается на 1 узел за шаг) и быстрый (двигается на 2 узла за шаг).
 * Когда быстрый указатель достигнет конца, медленный будет указывать на середину.
 *
 * Разворот второй половины: Начиная с середины, разворачиваем ссылки в списке, чтобы вторая половина шла в обратном порядке.
 *
 * Вычисление сумм: Теперь мы можем пройти по списку с начала и с "конца" (который теперь начинается с бывшей середины),
 * попарно складывая значения и находя максимальную сумму.
 */
fun pairSum2(head: ListNode?): Int {
    if (head == null) return 0

    // Шаг 1: Находим середину списка
    var slow = head
    var fast = head
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    // Шаг 2: Разворачиваем вторую половину списка
    var prev: ListNode? = null
    var current = slow
    while (current != null) {
        val next = current.next
        current.next = prev
        prev = current
        current = next
    }

    // Шаг 3: Вычисляем суммы пар и находим максимум
    var first = head
    var second = prev
    var maxSum = 0
    while (second != null) {
        val sum = first!!.`val` + second.`val`
        if (sum > maxSum) {
            maxSum = sum
        }
        first = first.next
        second = second.next
    }

    return maxSum
}

