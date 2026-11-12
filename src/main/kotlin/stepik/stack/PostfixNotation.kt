package stepik.stack

/**
 * 3.5 Стек
 *
 * Постфиксная запись (1 балл)
 *
 * В постфиксной записи (или обратной польской записи) операция записывается после двух операндов. Например, сумма двух чисел A и B
 * записывается как A B +. Запись B C + D * обозначает привычное нам (B + C) * D, а запись A B C + D * + означает
 * A + (B + C) * D. Достоинство постфиксной записи в том, что она не требует скобок и дополнительных соглашений о приоритете
 * операторов для своего чтения.
 *
 * Входные данные
 *
 * В единственной строке записано выражение в постфиксной записи, содержащее цифры и операции +, -, *.
 * Цифры и операции разделяются пробелами. В конце строки может быть произвольное количество пробелов.
 *
 * Выходные данные
 *
 * Необходимо вывести значение записанного выражения.
 */
fun main() {
//    val input = readln().trim().split(" ")
    val input = "8 9 + 1 7 - *".trim().split(" ")

    val stack = ArrayDeque<Int>()

    input.forEach { value ->
        when (value) {
            "+" -> stack.addLast(stack.removeLast() + stack.removeLast())
            "*" -> stack.addLast(stack.removeLast() * stack.removeLast())
            "-" -> {
                val num1 = stack.removeLast()
                val num2 = stack.removeLast()
                stack.addLast(num2 - num1)
            }

            else -> stack.addLast(value.toInt())
        }
    }

    print(stack.removeLast())
}