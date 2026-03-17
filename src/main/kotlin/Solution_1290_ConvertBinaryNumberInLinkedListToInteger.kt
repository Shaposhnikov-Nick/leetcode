/**
 * 1290 Convert Binary Number in a Linked List to Integer
 *
 * Easy
 *
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 *
 * The most significant bit is at the head of the linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 * Example 2:
 *
 * Input: head = [0]
 * Output: 0
 *
 *
 * Constraints:
 *
 * The Linked List is not empty.
 * Number of nodes will not exceed 30.
 * Each node's value is either 0 or 1.
 */
fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(0)
    val node3 = ListNode(1)
    node1.next = node2
    node2.next = node3
    getDecimalValue(node1)
}

/**
 * Проходим по  связанному списку и добавляем каждое его значение в другой список
 * Каждый бит преобразовываем:
 *
 * Возьмём список [1, 0, 1, 1] (двоичное число 1011₂ = 11₁₀):
 *
 * Шаг 1: Начало
 * acc = 0 (начальное значение)
 *
 * Шаг 2: Первый бит = 1
 * (acc shl 1) or bit
 * (0 shl 1) or 1    // 0 сдвиг влево на 1 = 0
 * 0 or 1 = 1        // новое acc = 1
 *
 * Шаг 3: Второй бит = 0
 * (1 shl 1) or 0    // 1 сдвиг влево на 1 = 2 (10₂)
 * 2 or 0 = 2        // новое acc = 2 (10₂)
 *
 * Шаг 4: Третий бит = 1
 * (2 shl 1) or 1    // 2 сдвиг влево на 1 = 4 (100₂)
 * 4 or 1 = 5        // новое acc = 5 (101₂)
 *
 * Шаг 5: Четвёртый бит = 1
 * (5 shl 1) or 1    // 5 сдвиг влево на 1 = 10 (1010₂)
 * 10 or 1 = 11      // новое acc = 11 (1011₂)
 *
 * Операторы:
 * shl - сдвиг влево (shift left). Умножает число на 2: x shl 1 = x * 2
 *
 * or - побитовое ИЛИ. Добавляет новый бит в конец числа
 *
 * Почему это работает?
 * Это классический алгоритм перевода двоичного числа в десятичное:
 *
 * Берём текущий результат
 *
 * Сдвигаем его влево (освобождаем место для нового бита)
 *
 * Добавляем новый бит через ИЛИ
 *
 * По сути, мы "собираем" число по одному биту слева направо.
 */
fun getDecimalValue(head: ListNode?): Int {
    val bits = mutableListOf<Int>()
    var current = head

    while (current != null) {
        bits.add(current.`val`)
        current = current.next
    }

    return bits.fold(0) { acc, bit -> (acc shl 1) or bit }
}

/**
 * Проходим по  связанному списку и добавляем каждое его значение в другой список строк
 * Объединяем строки в одну и преобразовываем в число
 */
fun getDecimalValue2(head: ListNode?): Int {
    val bits = mutableListOf<String>()
    var current = head

    while (current != null) {
        bits.add(current.`val`.toString())
        current = current.next
    }

    return bits.joinToString(separator = "").toInt(2)
}