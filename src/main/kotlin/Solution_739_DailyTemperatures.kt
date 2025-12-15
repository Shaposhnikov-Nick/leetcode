import java.util.ArrayDeque

/**
 * 739 Daily Temperatures
 *
 * Medium
 *
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 *
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 *
 *
 * Constraints:
 *
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 */
fun main() {
    val temperatures = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
    dailyTemperatures(temperatures)
}

/**
 * Алгоритм:
 *
 * Мы будем использовать монотонно убывающий стек, но вместо значений будем хранить индексы — чтобы вычислить количество дней.
 *
 * Проходим по массиву слева направо.
 *
 * Пока текущая температура больше, чем температура по индексу на вершине стека — мы нашли "более тёплый день" для этого индекса.
 *
 * Вычисляем разницу: i - indexFromStack и записываем в результат.
 *
 * Затем добавляем текущий индекс в стек.
 *
 *
 * Сложность:
 *
 * Время: O(n) — каждый индекс добавляется и удаляется один раз.
 *
 * Память: O(n) — для стека и результата.
 */
fun dailyTemperatures(temperatures: IntArray): IntArray {
    val stack = ArrayDeque<Int>() // по умолчанию 0
    val result = IntArray(temperatures.size)  // хранит индексы

    for (i in temperatures.indices) {
        // Пока текущая температура > температуры по индексу на вершине стека
        while (stack.isNotEmpty() && temperatures[i] > temperatures[stack.peek()]) {
            val prevIndex = stack.pop()
            result[prevIndex] = i - prevIndex
        }
        stack.push(i)
    }

    return result
}

/**
 * O(n2)
 *
 * Перебор всех последующих значений в массиве с целью поиска большего значения
 */
fun dailyTemperatures2(temperatures: IntArray): IntArray {
    for (i in temperatures.indices) {
        var moreTemp: Int? = null // большая температура
        for (j in i + 1..<temperatures.size) {
            if (temperatures[j] > temperatures[i]) {
                moreTemp = temperatures[j]
                temperatures[i] = j - i
                break
            }
        }
        if (moreTemp == null) temperatures[i] = 0 // если большая температура не найдена, устанавливаем 0
        moreTemp = null // зануляем значение для следующего поиска
    }


    return temperatures
}