/**
 * 463 Island Perimeter
 *
 * Easy
 *
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 *
 *
 * Example 1:
 *
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * Output: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image above.
 * Example 2:
 *
 * Input: grid = [[1]]
 * Output: 4
 * Example 3:
 *
 * Input: grid = [[1,0]]
 * Output: 4
 *
 *
 * Constraints:
 *
 * row == grid.length
 * col == grid[i].length
 * 1 <= row, col <= 100
 * grid[i][j] is 0 or 1.
 * There is exactly one island in grid.
 */
fun main() {
    val grid = arrayOf(intArrayOf(0, 1, 0, 0), intArrayOf(1, 1, 1, 0), intArrayOf(0, 1, 0, 0), intArrayOf(1, 1, 0, 0))
    islandPerimeter(grid)
}

/**
 * Периметр — это сумма рёбер клеток суши, которые граничат с водой (или выходят за пределы сетки).
 * Проходим по каждой клетке
 * Если это вода, то пропускаем
 * Если это суша, то проверяем соседние клетки, если в них вода, считае мэто ребро в периметр
 */
fun islandPerimeter(grid: Array<IntArray>): Int {
    var perimeter = 0

    // Проходим по каждой клетке
    for (rowIndex in grid.indices) {
        for (colIndex in grid[rowIndex].indices) {
            // Если это вода, то пропускаем
            if (grid[rowIndex][colIndex] == 0) continue
            // Если это суша, то проверяем соседние клетки, если в них вода, считаем это ребро в периметр
            // check top
            if ((rowIndex >= 1 && grid[rowIndex - 1][colIndex] == 0) || rowIndex == 0) perimeter++
            // check bottom
            if ((rowIndex < grid.size - 1 && grid[rowIndex + 1][colIndex] == 0) || rowIndex == grid.size - 1) perimeter++
            // check left
            if ((colIndex > 0 && grid[rowIndex][colIndex - 1] == 0) || colIndex == 0) perimeter++
            // check right
            if ((colIndex < grid[rowIndex].size - 1 && grid[rowIndex][colIndex + 1] == 0) || colIndex == grid[rowIndex].size - 1) perimeter++
        }
    }

    return perimeter
}