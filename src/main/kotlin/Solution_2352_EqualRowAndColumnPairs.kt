/**
 * 2352 Equal Row and Column Pairs
 *
 * Medium
 *
 * Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
 *
 * A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
 * Output: 1
 * Explanation: There is 1 equal row and column pair:
 * - (Row 2, Column 1): [2,7,7]
 * Example 2:
 *
 *
 * Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
 * Output: 3
 * Explanation: There are 3 equal row and column pairs:
 * - (Row 0, Column 0): [3,1,2,2]
 * - (Row 2, Column 2): [2,4,2,2]
 * - (Row 3, Column 2): [2,4,2,2]
 */
fun main() {
//    val grid = arrayOf(intArrayOf(3, 2, 1), intArrayOf(1, 7, 6), intArrayOf(2, 7, 7))
    val grid = arrayOf(intArrayOf(3, 1, 2, 2), intArrayOf(1, 4, 4, 4), intArrayOf(2, 4, 2, 2), intArrayOf(2, 5, 2, 2))
    println(equalPairs(grid))
}

fun equalPairs(grid: Array<IntArray>): Int {
    // массив для хранения колонок
    val columns = Array(grid.size) { List(0) { 0 } }
    // массив строк
    val rows = grid.map { it.toList() }

    // заполняем колонки
    for (i in grid.indices) {
        val column = mutableListOf<Int>()
        for (j in grid.indices) {
            column.add(grid[j][i])
        }
        columns[i] = column
    }

    // считаем количество совпадений колонок и строк
    var resCount = 0
    for (row in rows) {
        val countSameColumns = columns.count { it == row }
        resCount += countSameColumns
    }

    return resCount
}