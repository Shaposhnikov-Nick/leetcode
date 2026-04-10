import java.util.ArrayDeque;

public class Solution_200_NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        numIslandsDFS(grid);
        numIslandsBFS(grid);
    }

    /**
     * DFS  решение
     */
    private static int numIslandsDFS(char[][] grid) {
        var count = 0;

        // проходим по каждой клетке в матрице
        // rIndex - индекс строки в матрице
        // cIndex - индекс колонки в матрице
        for (int rIndex = 0; rIndex < grid.length; rIndex++) {
            for (int cIndex = 0; cIndex < grid[rIndex].length; cIndex++) {
                var value = grid[rIndex][cIndex];
                // если ячейка является землей, увеличиваем счетчик островов
                // и начинаем проверять все соседние ячейки.
                // если соседние ячейки тоже земля, то меняем их на воду
                // чтобы другие рекурсивные вызовы не считали их
                if (value == '1') {
                    count++;
                    dfs(grid, rIndex, cIndex);
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] grid, int rIndex, int cIndex) {
        // 1. выход за границы
        if (rIndex < 0 || rIndex > grid.length - 1 || cIndex < 0 || cIndex > grid[rIndex].length - 1) return;
        // 2. если не земля — выходим
        if (grid[rIndex][cIndex] == '0') return;
        // 3. помечаем клетку как воду, чтобы другие рекурсивные вызовы не посчитали ее за землю
        grid[rIndex][cIndex] = '0';
        // 4. идём в 4 стороны
        dfs(grid, rIndex + 1, cIndex);
        dfs(grid, rIndex - 1, cIndex);
        dfs(grid, rIndex, cIndex + 1);
        dfs(grid, rIndex, cIndex - 1);
    }

    /**
     * BFS  решение
     */
    private static int numIslandsBFS(char[][] grid) {
        var count = 0;

        // проходим по каждой клетке в матрице
        // rIndex - индекс строки в матрице
        // cIndex - индекс колонки в матрице
        for (int rIndex = 0; rIndex < grid.length; rIndex++) {
            for (int cIndex = 0; cIndex < grid[rIndex].length; cIndex++) {
                var value = grid[rIndex][cIndex];
                // если значение равно 1, значит нашли новый остров
                if (value == '1') {
                    count++;
                    // проверяем соседние ячейки
                    bfs(grid, rIndex, cIndex);
                }
            }
        }

        return count;
    }

    private static void bfs(char[][] grid, int rIndex, int cIndex) {
        // создаем очередь для хранения соседних полей со знчением 1
        // и добавляем первое поле
        var queue = new ArrayDeque<int[]>();
        queue.addLast(new int[]{rIndex, cIndex});
        // сразу помечаем начальное поле как 0
        // чтобы сюда повторно не заходили из других соседних полей
        grid[rIndex][cIndex] = '0';

        // проходим по всем полям в очереди, и если соседнее поле тоже 1, добавяем его в очередь
        while (!queue.isEmpty()) {
            // достаем поле из очереди // достаем поле из очереди
            var cell = queue.removeFirst();
            // номер строки
            var rI = cell[0];
            // номер колонки
            var cI = cell[1];

            // определяем координаты граничных полей сверху, снизу, слева, спррава
            var boundedCells = new int[][]{{rI - 1, cI}, {rI + 1, cI}, {rI, cI - 1}, {rI, cI + 1}};

            // проходим по граничащим полям
            for (var bCell : boundedCells) {
                var r = bCell[0];
                var c = bCell[1];

                // проверяем, что координаты не выходят за границы матрицы
                // и если значение поля равно 1 (т.е. земля), заменяем на 0 и добавляем поле в очередь,
                // чтобы проверить грничащие с ним поля
                if (r >= 0 && r < grid.length && c >= 0 && c < grid[r].length && grid[r][c] == '1') {
                    grid[r][c] = '0';
                    queue.addLast(bCell);
                }
            }
        }
    }
}
