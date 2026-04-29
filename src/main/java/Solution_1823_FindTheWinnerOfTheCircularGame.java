import java.util.ArrayDeque;

public class Solution_1823_FindTheWinnerOfTheCircularGame {
    public static void main(String[] args) {
        var n = 5;
        var k = 2;
        findTheWinner(n, k);
    }

    // Пример для 5 игроков и  k = 2
    // 1 2 3 4 5
    // 2 3 4 5 1
    // 3 4 5 1
    // 4 5 1 3
    // 5 1 3
    // 1 3 5
    // 3 5
    // 5 3
    // 3

    /**
     * Добавляем всех n игроков в очередь, чтобы можно было ходить по кругу
     * Установим счетчик проходящих игроков
     * Каждый раз достаем игрока из очереди, если при этом счетчик равен k, то удаляем игрока и сбрасываем счетчик,
     * а если не равен, добавляем игрока в конец очереди и инкрементируем счетчик
     * В конечно итоге остается только один игрок
     */
    private static int findTheWinner(int n, int k) {
        var queue = new ArrayDeque<Integer>();

        // Добавляем всех n игроков в очередь, чтобы можно было ходить по кругу
        for (int i = 1; i <= n; i++) {
            queue.addLast(i);
        }
        // Установим счетчик проходящих игроков
        var counter = 1;
        while (queue.size() > 1) {
            // Каждый раз достаем игрока из очереди
            var gamer = queue.removeFirst();
            if (counter == k) {
                // если при этом счетчик равен k, то удаляем игрока и сбрасываем счетчик
                counter = 1;
            } else {
                // если не равен, добавляем игрока в конец очереди и инкрементируем счетчик
                queue.addLast(gamer);
                counter++;
            }
        }

        // В конечно итоге остается только один игрок
        return queue.getFirst();
    }
}
