public class Solution_463_IslandPerimeter {
    public static void main(String[] args) {
        var grid = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        islandPerimeter(grid);
    }

    /**
     * Периметр — это сумма рёбер клеток суши, которые граничат с водой (или выходят за пределы сетки).
     * Проходим по каждой клетке
     * Если это вода, то пропускаем
     * Если это суша, то проверяем соседние клетки, если в них вода, считае мэто ребро в периметр
     */
    private static int islandPerimeter(int[][] grid) {
        var perimeter = 0;

        // Проходим по каждой клетке
        for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            for (int colIndex = 0; colIndex < grid[rowIndex].length; colIndex++) {
                // Если это вода, то пропускаем
                if (grid[rowIndex][colIndex] == 0) continue;
                // Если это суша, то проверяем соседние клетки, если в них вода, считаем это ребро в периметр
                // check top
                if ((rowIndex > 0 && grid[rowIndex - 1][colIndex] == 0) || rowIndex == 0) perimeter++;
                // check bottom
                if ((rowIndex < grid.length - 1 && grid[rowIndex + 1][colIndex] == 0) || rowIndex == grid.length - 1)
                    perimeter++;
                // check left
                if ((colIndex > 0 && grid[rowIndex][colIndex - 1] == 0) || colIndex == 0) perimeter++;
                // check right
                if ((colIndex < grid[rowIndex].length - 1 && grid[rowIndex][colIndex + 1] == 0) || colIndex == grid[rowIndex].length - 1)
                    perimeter++;
            }

        }
        return perimeter;
    }
}
