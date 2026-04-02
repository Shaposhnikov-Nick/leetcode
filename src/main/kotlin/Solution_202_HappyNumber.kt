/**
 * 202 Happy Number
 *
 * Easy
 *
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * Example 2:
 *
 * Input: n = 2
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= n <= 231 - 1
 */
fun main() {
    val n = 19
    isHappy(n)
}

/**
 * Раскладываем число на цифры и находим сумму их квадратов
 * Если число 1 достигнуто — ответ true
 * Чтобы определить цикл можно сохранять все встреченные числа. Если на каком-то шаге текущее число уже есть в множестве
 * и оно не равно 1 — цикл найден, возвращаем false
 *
 * Важный факт
 * Доказано, что для любого числа этот процесс либо приходит к 1, либо входит в цикл
 * 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4.
 * Поэтому можно проверять: если текущее число равно 4, значит, цикл начался → вернуть false
 */
fun isHappy(n: Int): Boolean {
    val set = mutableSetOf<Int>()
    var num = n

    // пока сумма не встретилась повторно, продолжаем считать сумму квадратов цифр
    while (num !in set) {
        set.add(num)
        num = getSum(num)
        // если сумма равн 1, значит число счастливое
        if (num == 1) return true
    }

    return false
}

// Раскладываем число на цифры и находим сумму их квадратов
private fun getSum(n: Int): Int {
    var number = n
    var sum = 0

    while (number > 0) {
        val digit = number % 10
        sum += digit * digit
        number /= 10
    }

    return sum
}