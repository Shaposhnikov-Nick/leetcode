import java.util.*;

public class Solution_2352_EqualRowAndColumnPairs {
    public static void main(String[] args) {
        var grid = new int[][]{{3, 1, 2, 2}, {1, 4, 4, 4}, {2, 4, 2, 2}, {2, 5, 2, 2}};
        System.out.println(equalPairs(grid));
    }

    private static int equalPairs(int[][] grid) {
        var columns = new ArrayList<List<Integer>>();
        var rows = Arrays.stream(grid).map(row -> Arrays.stream(row).boxed().toList()).toList();

        for (int i = 0; i < grid.length; i++) { // столбец
            var column = new ArrayList<Integer>();
            for (int j = 0; j < grid.length; j++) { // строка
                column.add(grid[j][i]);
            }
            columns.add(column);
        }

        return (int) rows.stream()
                .flatMap(row -> columns.stream().filter(row::equals))
                .count();
    }

    public int equalPairs2(int[][] grid) {
        int size = grid.length;
        Map<String, Integer> pair = new HashMap<>();

        for (int[] row : grid) {
            String r = Arrays.toString(row);
            pair.put(r, pair.getOrDefault(r, 0) + 1);
        }

        int j = 0, count = 0;
        while (j < size) {
            int[] col = new int[size];
            for (int i = 0; i < size; i++) {
                col[i] = grid[i][j];
            }
            j++;
            count += pair.getOrDefault(Arrays.toString(col), 0);
        }
        return count;
    }
}
