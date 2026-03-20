public class Solution_200_NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        numIslands(grid);
    }

    private static int numIslands(char[][] grid) {
        var count = 0;

        for (int rIndex = 0; rIndex < grid.length; rIndex++) {
            for (int cIndex = 0; cIndex < grid[rIndex].length; cIndex++) {
                var value = grid[rIndex][cIndex];
                if (value == '1') {
                    count++;
                    dfs(grid, rIndex, cIndex);
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] grid, int rIndex, int cIndex) {
        if (rIndex < 0 || rIndex > grid.length - 1 || cIndex < 0 || cIndex > grid[rIndex].length - 1) return;
        if (grid[rIndex][cIndex] == '0') return;

        grid[rIndex][cIndex] = '0';

        dfs(grid, rIndex + 1, cIndex);
        dfs(grid, rIndex - 1, cIndex);
        dfs(grid, rIndex, cIndex + 1);
        dfs(grid, rIndex, cIndex - 1);
    }
}
