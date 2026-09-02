/**
 * 2487 Remove Nodes From Linked List
 *
 * Medium
 *
 * You are given the head of a linked list.
 *
 * Remove every node which has a node with a greater value anywhere to the right side of it.
 *
 * Return the head of the modified linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [5,2,13,3,8]
 * Output: [13,8]
 * Explanation: The nodes that should be removed are 5, 2 and 3.
 * - Node 13 is to the right of node 5.
 * - Node 13 is to the right of node 2.
 * - Node 8 is to the right of node 3.
 * Example 2:
 *
 * Input: head = [1,1,1,1]
 * Output: [1,1,1,1]
 * Explanation: Every node has value 1, so no nodes are removed.
 *
 *
 * Constraints:
 *
 * The number of the nodes in the given list is in the range [1, 105].
 * 1 <= Node.val <= 105
 */
fun main() {
    val node1 = ListNode(5)
    val node2 = ListNode(2)
    val node3 = ListNode(13)
    val node4 = ListNode(3)
    val node5 = ListNode(8)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    removeNodes(node1)
}

/**
 * Решение с использованием стека
 *
 * Складываем значения узлов в стек
 * Если значение больше, чем те, что лежат в стеке, удаляем их
 * Строим новый список из оставшихся в стеке значений
 */
fun removeNodes(head: ListNode?): ListNode? {
    val stack = ArrayDeque<Int>()
    var current = head

    // Собираем все значения в стек
    while (current != null) {
        // Удаляем из стека все меньшие значения
        while (stack.isNotEmpty() && stack.last() < current.`val`) {
            stack.removeLast()
        }

        stack.addLast(current.`val`)
        current = current.next
    }

    val dummy = ListNode(-1)
    current = dummy

    // Строим новый список из стека
    while (stack.isNotEmpty()) {
        current!!.next = ListNode(stack.removeFirst())
        current = current.next
    }

    return dummy.next
}

/**
 * Рекурсивное решение
 *
 * Как это работает:
 * 1. Базовый случай (условие выхода)
 * kotlin
 * if (head?.next == null) return head
 * Если список пустой (null) или мы дошли до последнего узла (head.next == null), возвращаем текущий узел.
 *
 * Последний узел всегда остается, так как справа от него нет никого с большим значением.
 *
 * 2. Рекурсивный спуск
 * kotlin
 * val nextNode = removeNodes(head.next)
 * Мы рекурсивно обрабатываем правую часть списка (все узлы, которые находятся справа от текущего).
 *
 * Рекурсия идет до самого конца списка, а затем начинает возвращаться обратно.
 *
 * 3. Обработка на возврате (пост-обработка)
 * kotlin
 * if (nextNode != null && head.`val` < nextNode.`val`) {
 *     return nextNode
 * }
 * Когда рекурсия возвращается, nextNode — это голова уже обработанной правой части списка.
 *
 * Проверяем: если значение текущего узла head меньше значения первого узла справа (nextNode), значит, справа есть узел с большим значением.
 *
 * В этом случае мы удаляем текущий узел, просто возвращая nextNode (пропускаем head).
 *
 * 4. Сохранение узла
 * kotlin
 * head.next = nextNode
 * return head
 * Если текущий узел не удаляется (его значение >= значения справа), мы связываем его с обработанной правой частью и возвращаем его.
 *
 * Почему это работает?
 * Ключевая идея: когда мы обрабатываем список справа налево, мы всегда знаем, какое максимальное значение находится справа от текущего узла (это nextNode.val).
 *
 * Если head.val < nextNode.val, значит справа есть узел с большим значением → удаляем head.
 *
 * Если head.val >= nextNode.val, то head должен остаться, и он становится новым "максимумом" для узлов слева.
 *
 * Сложность
 * Время: O(n) — каждый узел посещается один раз
 *
 * Память: O(n) — из-за рекурсивного стека вызовов (глубина рекурсии до n)
 */
fun removeNodes2(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    val nextNode = removeNodes(head.next)

    // Если следующий узел имеет большее значение, удаляем текущий
    if (nextNode != null && head.`val` < nextNode.`val`) {
        return nextNode
    }

    head.next = nextNode
    return head
}
