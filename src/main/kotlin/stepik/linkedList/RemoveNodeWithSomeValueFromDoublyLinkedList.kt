package stepik.linkedList

/**
 * 3.4 Списки
 *
 * Удалите все узлы с заданным значением из двусвязного списка.
 *
 * Формат входных данных:
 *
 * Первая строка содержит число n (1 ≤ n ≤ 10ˆ5) - количество элементов в списке.
 * Вторая строка содержит n целых чисел (1 ≤ a_i ≤ 10ˆ9), разделенных пробелами - значения элементов списка.
 * Третья строка содержит целое число val (1 ≤ val ≤ 10ˆ9) - значение, которое нужно удалить из списка.
 * Формат выходных данных:
 *
 * Все значения элементов обновленного списка, разделенные пробелами. Если список становится пустым после удаления, выведите None.
 * Тестовые данные
 *
 * № Теста
 * Входные данные
 * Выходные данные
 * 1
 *
 * 5
 * 1 2 3 4 5
 * 3
 */
fun main() {
//    val n = readln().toInt()
//    val values = readln().split(" ").map { it.toInt() }
//    val target = readln().toInt()

    val values = listOf(3, 3, 3)
    val target = 3

    // Создаем двусвязный список
    // Создаем фиктивный начальный узел
    val dummy = DoublyListNode(-1)
    var current: DoublyListNode? = dummy

    // Для каждого значения создаем узел и добавляем ссылки на следующий и предыдущий
    for (i in values.indices) {
        val node = DoublyListNode(values[i])
        current?.next = node
        node.prev = current

        current = node
    }

    current = dummy

    // Проходим по списку, начиная с фиктивной головы
    while (current?.next != null) {
        // Если значение следующего узла равно target
        if (current.next?.value == target) {
            val nodeToRemove = current.next
            // Определяем новый следующий узел после target
            val newNext = nodeToRemove?.next
            // заменяем ссылки на следующий и предыдущий узлы, исключая из списка узел с target
            // при это не двигаем указатель current, чтобы в следующей итерации проверить новый узел
            current.next = newNext
            newNext?.prev = current
        } else {
            // Двигаем указатель current
            current = current.next
        }
    }

    current = dummy.next

    // Выводим список на экран
    if (current == null) {
        print("None")
    } else {
        while (current != null) {
            print("${current.value} ")
            current = current.next
        }
    }

}

class DoublyListNode(val value: Int) {
    var next: DoublyListNode? = null
    var prev: DoublyListNode? = null
}