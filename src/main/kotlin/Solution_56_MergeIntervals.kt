/**
 * 56 Merge Intervals
 *
 * Medium
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * Example 3:
 *
 * Input: intervals = [[4,7],[1,4]]
 * Output: [[1,7]]
 * Explanation: Intervals [1,4] and [4,7] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
fun main() {
    val intervals = arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))
    merge(intervals)
}

/**
 * Сортируем массив по возрастанию начал интервалов
 * Сравниваем начало каждого интервала с концом предыдущего, если начало внутри предыдущего интервала, заменяем
 * оба интервала общим интервалом, включающим оба этих интервала
 */
fun merge(intervals: Array<IntArray>): Array<IntArray> {
    val result = mutableListOf<IntArray>()

    // Сортируем массив по возрастанию начал интервалов
    val comparator = Comparator<IntArray> { o1, o2 -> o1[0] - o2[0] }
    intervals.sortWith(comparator)

    for (interval in intervals) {
        // Если это первый интервал в массиве, добавляем его в result
        if (result.isEmpty()) {
            result.add(interval)
            continue
        }

        // берем последний результирующий интервал
        val lastInterval = result.last()

        // если начало нового интервала лежит в границах предыдущего
        if (interval[0] <= lastInterval[1]) {
            // удаляем предыдущий интервал
            result.removeLast()
            // определяем границы нового общего интервала и добавляем в result
            val start = lastInterval[0]
            val end = maxOf(lastInterval[1], interval[1])
            result.add(intArrayOf(start, end))
        } else {
            // иначе просто добавляем интервал в result
            result.add(interval)
        }
    }

    return result.toTypedArray()
}