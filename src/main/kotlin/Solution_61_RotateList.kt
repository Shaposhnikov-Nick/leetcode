/**
 * 61 Rotate List
 *
 * Medium
 *
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * Example 2:
 *
 *
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
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

    val k = 100

    rotateRight(node1, k)
}

/**
 * Для удобства вставки узла из конца в начало используем dummy head
 * Определим размер списка
 * Вычислим, сколько на самом деле нужно сделать итераций по перемещению конечного узла в начало:
 * учитываем, что каждые size раз итераций список просто развернется в обратную сторону,
 * и что 2 * size раз итераций список будет таким же как в начале.
 * Поэтому если k больше чем 2 * size, найдем нужное количество итераций как остаток от деления.
 * <p>
 * Доходим до предпоследнего узла
 * Чтобы последний узел стал первым, добавляем ему ссылку на реальный первый узел
 * Фиктивная голова должна ссылаться на новый реальный первый узел
 * Чтобы избежать зацикливания, у нового последнего узла зануляем ссылку на следующий узел
 */
fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head?.next == null) return head
    // Первый реальный узел в списке
    var firstNode = head
    // Для удобства вставки узла из конца в начало используем dummy head
    val dummy = ListNode(200)
    dummy.next = head

    // Определим размер списка
    var size = 1
    var cur = head
    while (cur?.next != null) {
        size++
        cur = cur.next
    }

    // Вычислим, сколько на самом деле нужно сделать итераций по перемещению конечного узла в начало:
    // учитываем, что каждые size раз итераций список просто развернется в обратную сторону,
    // и что 2 * size раз итераций список будет таким же как в начале.
    // Поэтому если k больше чем 2 * size, найдем нужное количество итераций как остаток от деления.
    val n = if (k > 2 * size) k % (2 * size) else k

    for (i in 0 until n) {
        var current = dummy
        // Доходим до предпоследнего узла
        while (current.next != null && current.next!!.next != null) {
            current = current.next!!
        }
        val last = current.next!!
        // Чтобы последний узел стал первым, добавляем ему ссылку на реальный первый узел
        last.next = firstNode
        // Фиктивная голова теперь должна ссылаться на новый реальный первый узел
        dummy.next = last
        // Чтобы избежать зацикливания, у нового последнего узла зануляем ссылку на следующий узел
        current.next = null
        // Обновляем ссылку на реальный первый узел
        firstNode = last
    }

    return firstNode
}