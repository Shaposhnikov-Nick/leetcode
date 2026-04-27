import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution_56_MergeIntervals {
    public static void main(String[] args) {
        var intervals = new int[][]{{2, 6}, {1, 3}, {4, 7}, {8, 10}, {15, 18}};
        // {1, 3} {2, 6} {4, 7} {8, 10} {15, 18}
        merge(intervals);
    }

    /**
     * Сортируем массив по возрастанию начал интервалов
     * Сравниваем начало каждого интервала с концом предыдущего, если начало внутри предыдущего интервала, заменяем
     * оба интервала общим интервалом, включающим оба этих интервала
     */
    private static int[][] merge(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();
        ArrayList<int[]> list = new ArrayList<>(Arrays.asList(intervals));

        // Сортируем массив по возрастанию начал интервалов
        Comparator<int[]> comparator = (int[] o1, int[] o2) -> o1[0] - o2[0];
        list.sort(comparator);

        for (int[] interval : list) {
            // Если это первый интервал в массиве, добавляем его в result
            if (result.isEmpty()) {
                result.add(interval);
                continue;
            }

            // берем последний результирующий интервал
            int[] lastInterval = result.getLast();

            // если начало нового интервала лежит в границах предыдущего
            if (interval[0] <= lastInterval[1]) {
                // удаляем предыдущий интервал
                result.removeLast();
                // определяем границы нового общего интервала и добавляем в result
                var start = lastInterval[0];
                var end = Math.max(interval[1], lastInterval[1]);
                result.add(new int[]{start, end});
            } else {
                // иначе просто добавляем интервал в result
                result.add(interval);
            }
        }

        return result.toArray(new int[0][]);
    }


}


