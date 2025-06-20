package stepik.linkedList

/**
 * Удалите из односвязного списка все узлы с заданным значением.
 *
 * Формат входных данных:
 *
 * Первая строка содержит число n (1 ≤ n ≤ 10^5) - количество элементов в списке.
 *
 * Вторая строка содержит n целых чисел (1 ≤ a ≤ 10^9), разделенных пробелами - значения элементов списка.
 *
 * Третья строка содержит целое число val (1 ≤ val ≤ 10^9) - значение, которое нужно удалить из списка.
 *
 * Формат выходных данных
 *
 * Все значения элементов обновленного списка, разделенные пробелами. Если список становится пустым, выведите None.
 *
 * Sample Input 1:
 *
 * 5
 *
 * 1 2 3 4 5
 *
 * 3
 * Sample Output 1:
 *
 * 1 2 4 5
 *
 * Sample Input 2:
 *
 * 1
 *
 * 1
 *
 * 1
 *
 * Sample Output 2:
 *
 * None
 */
fun main() {
    val n = readln()
    val values = readln().split(" ").map { it.toInt() }
    val `val` = readln().toInt()

//    val values = listOf(1, 2, 3, 4, 5)
//    val `val` = 3

    // Создаем связный список
    val dummy = ListNode(0)  // Фиктивный начальный узел
    var tail = dummy

    // Строим связный список
    for (value in values) {
        tail.next = ListNode(value)
        tail = tail.next!!
    }

    // Удаляем узлы с заданным значением
    var current: ListNode? = dummy
    while (current?.next != null) {
        if (current.next?.value == `val`) {
            current.next = current.next?.next
        } else {
            current = current.next!!
        }
    }

    // Выводим результат
    var node = dummy.next
    if (node == null) {
        println("None")
    } else {
        while (node != null) {
            print("${node.value} ")
            node = node.next
        }
    }

}

class ListNode(val value: Int) {
    var next: ListNode? = null
}