/**
 * 119 Pascal's Triangle II
 *
 * Easy
 *
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 *
 *
 *
 * Example 1:
 *
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * Example 2:
 *
 * Input: rowIndex = 0
 * Output: [1]
 * Example 3:
 *
 * Input: rowIndex = 1
 * Output: [1,1]
 *
 *
 * Constraints:
 *
 * 0 <= rowIndex <= 33
 */
fun main() {
    val rowIndex = 3
    getRow(rowIndex)
}

/**
 * Создаем массив для хранения строк треугольника
 * Добавляем две первые строки для упрощения последующих вычислений
 * Начиная с 3-й строки считаем каждое значение как сумму двух на предыдущей строке
 * В начале и конце новой строки добавляем 1
 */
fun getRow(rowIndex: Int): List<Int> {
    if (rowIndex == 0) return listOf(1)
    // Создаем массив для хранения строк треугольника
    val result = mutableListOf<List<Int>>()
    // Добавляем две первые строки для упрощения последующих вычислений
    result.add(listOf(1))
    result.add(listOf(1, 1))

    // Для остальных считаем каждое значение как сумму двух на предыдущей строке
    repeat(rowIndex - 2) {
        val lastRow = result.last()
        val newRow = mutableListOf<Int>()

        for (j in lastRow.indices) {
            // В начале новой строки добавляем 1
            if (j == 0) newRow.add(1)
            else {
                val value = lastRow[j - 1] + lastRow[j]
                newRow.add(value)
            }
        }
        // В конце новой строки добавляем 1
        newRow.add(1)
        result.add(newRow)
    }

    // Возвращаем последнюю нижнюю строку треугольника
    return result.last()
}