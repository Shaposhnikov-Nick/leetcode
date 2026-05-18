/**
 * 40. Combination Sum II
 *
 * Medium
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
fun main() {
    val candidates = intArrayOf(10, 1, 2, 7, 6, 1, 5)
    val target = 8
    combinationSum2(candidates, target)
}

/**
 * Сортировка массива позволяет эффективно обрабатывать дубликаты и выполнять отсечение
 *
 * Метод backtrack рекурсивно перебирает комбинации, начиная с индекса start
 *
 * Пропуск дубликатов (if (i > start && sorted[i] == sorted[i - 1]) continue) гарантирует, что мы не добавим одинаковые комбинации в результат
 *
 * Отсечение (if (num > remaining) break) прерывает цикл, так как все последующие числа будут больше
 *
 * Каждое число используется не более одного раза, поэтому следующий вызов начинается с i + 1
 *
 * Пример работы:
 *
 * Для candidates = [10,1,2,7,6,1,5], target = 8
 *
 * После сортировки: [1,1,2,5,6,7,10]
 *
 * Результат: [[1,1,6], [1,2,5], [1,7], [2,6]]
 */
fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val sorted = candidates.sorted() // Сортируем массив для удобства обработки дубликатов

    fun backtrack(start: Int, remaining: Int, current: MutableList<Int>) {
        // Если осталось 0, значит нашли подходящую комбинацию
        if (remaining == 0) {
            result.add(current.toList())
            return
        }

        for (i in start until sorted.size) {
            // Пропускаем дубликаты на том же уровне рекурсии
            if (i > start && sorted[i] == sorted[i - 1]) continue

            val num = sorted[i]
            // Если текущее число больше оставшейся суммы, прерываем цикл
            if (num > remaining) break

            current.add(num)
            backtrack(
                i + 1,
                remaining - num,
                current
            ) // i + 1, потому что каждое число можно использовать только один раз
            current.removeAt(current.size - 1) // Откатываем изменения
        }
    }

    backtrack(0, target, mutableListOf())
    return result
}
