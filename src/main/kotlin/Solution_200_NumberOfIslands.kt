/**
 * 200. Number of Islands
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
fun main() {
    val grid = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '0')
    )
    numIslandsDFS(grid)
    numIslandsBSF(grid)
}

/**
 *DFS  решение
 */
fun numIslandsDFS(grid: Array<CharArray>): Int {
    // количество островов
    var count = 0

    // проходим по каждой клетке в матрице
    // rIndex - индекс строки в матрице
    // cIndex - индекс колонки в матрице
    for (rIndex in grid.indices) {
        for (cIndex in grid[rIndex].indices) {
            val value = grid[rIndex][cIndex]
            // если ячейка является землей, увеличиваем счетчик островов
            // и начинаем проверять все соседние ячейки.
            // если соседние ячейки тоже земля, то меняем их на воду
            // чтобы другие рекурсивные вызовы не считали их
            if (value == '1') {
                count++
                dfs(grid, rIndex, cIndex)
            }
        }
    }

    return count
}

fun dfs(grid: Array<CharArray>, rIndex: Int, cIndex: Int) {
    // 1. выход за границы
    if (rIndex < 0 || rIndex > grid.size - 1 || cIndex < 0 || cIndex > grid[rIndex].size - 1) return

    // 2. если не земля — выходим
    if (grid[rIndex][cIndex] == '0') return

    // 3. помечаем клетку как воду, чтобы другие рекурсивные вызовы не посчитали ее за землю
    grid[rIndex][cIndex] = '0'

    // 4. идём в 4 стороны
    dfs(grid, rIndex + 1, cIndex)
    dfs(grid, rIndex - 1, cIndex)
    dfs(grid, rIndex, cIndex + 1)
    dfs(grid, rIndex, cIndex - 1)
}

/**
 *BFS  решение
 */
fun numIslandsBSF(grid: Array<CharArray>): Int {
    // количество островов
    var islands = 0

    // проходим по каждой клетке в матрице
    // rIndex - индекс строки в матрице
    // cIndex - индекс колонки в матрице
    for (rIndex in grid.indices) {
        for (cIndex in grid[rIndex].indices) {
            val value = grid[rIndex][cIndex]
            // если значение равно 1, значит нашли новый остров
            if (value == '1') {
                islands++
                // проверяем соседние ячейки
                bfs(grid, rIndex, cIndex)
            }
        }
    }

    return islands
}

/**
 *
 */
fun bfs(grid: Array<CharArray>, rIndex: Int, cIndex: Int) {
    // создаем очередь для хранения соседних полей со знчением 1
    // и добавляем первое поле
    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.addLast(rIndex to cIndex)

    // сразу помечаем начальное поле как 0
    // чтобы сюда повторно не заходили из других соседних полей
    grid[rIndex][cIndex] = '0'

    // проходим по всем полям в очереди, и если соседнее поле тоже 1, добавяем его в очередь
    while (queue.isNotEmpty()) {
        // достаем поле из очереди
        val cell = queue.removeFirst()
        // номер строки
        val r = cell.first
        // номер колонки
        val c = cell.second

        // определяем координаты граничных полей сверху, снизу, слева, спррава
        val boundedCells = arrayOf(r - 1 to c, r + 1 to c, r to c - 1, r to c + 1)

        // проходим по граничащим полям
        for (cell in boundedCells) {
            val r = cell.first
            val c = cell.second
            // проверяем, что координаты не выходят за границы матрицы
            // и если значение поля равно 1 (т.е. земля), заменяем на 0 и добавляем поле в очередь,
            // чтобы проверить грничащие с ним поля
            if (r >= 0 && r < grid.size && c >= 0 && c < grid[r].size && grid[r][c] == '1') {
                grid[r][c] = '0'
                queue.addLast(r to c)
            }
        }

    }

}