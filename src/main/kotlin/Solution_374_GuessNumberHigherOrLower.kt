fun main() {
    val n = 11
    guessNumber(n)
}

/**
 * используем бинарный поиск
 */
fun guessNumber(n: Int): Int {
    var minNum = 1
    var maxNum = n

    while (minNum <= maxNum) {
        // ищем середину
        val mid = minNum + (maxNum - minNum) / 2
        when (guess(mid)) {
            // если pick = mid возвращаем ответ
            0 -> return mid
            // если pick < mid уменьшаем минимальное значение
            -1 -> maxNum = mid - 1
            // если pick > mid увеличиваем максимальное значение
            1 -> minNum = mid + 1
        }
    }
    return -1 // не должно достигаться
}

fun guess(num: Int): Int {
    val pick = 1
    return if (num == pick) 0
    else if (num > pick) -1
    else 1
}