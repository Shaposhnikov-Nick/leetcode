import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_506_RelativeRanks {
    public static void main(String[] args) {
        var score = new int[]{10, 3, 8, 9, 4};
        findRelativeRanks(score);
    }

    private static String[] findRelativeRanks(int[] score) {
        // Используем очередь с приоритетом для хранения баллов (reverseOrder() чтобы сортировка была по убыванию)
        var heap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        var answer = new String[score.length];

        // Добавляем в очередь баллы каждого участника
        for (var value : score) {
            heap.add(value);
        }

        var scoreList = Arrays.stream(score)
                .boxed()
                .toList();

        for (int place = 0; place < score.length; place++) {
            // Берем из очереди баллы каждого участника
            var value = heap.poll();
            // Ищем индекс этого участника в score
            var index = scoreList.indexOf(value);
            // Определяем место участника и добавляем в answer с тем же индексом
            switch (place) {
                case 0 -> answer[index] = "Gold Medal";
                case 1 -> answer[index] = "Silver Medal";
                case 2 -> answer[index] = "Bronze Medal";
                default -> answer[index] = String.valueOf(place + 1);
            }
        }

        return answer;
    }
}
