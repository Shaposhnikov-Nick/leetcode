import java.util.ArrayDeque;
import java.util.Map;

public class Solution_2073_TimeNeededToBuyTickets {
    public static void main(String[] args) {
        var tickets = new int[]{5, 1, 1, 1};
        var k = 0;
        timeRequiredToBuy(tickets, k);
    }

    private static int timeRequiredToBuy(int[] tickets, int k) {
        var time = 0;
        var queue = new ArrayDeque<Map.Entry<Integer, Integer>>();

        // Заполняем очередь парами (индекс человека, сколько билетов ему нужно)
        for (int i = 0; i < tickets.length; i++) {
            queue.addLast(Map.entry(i, tickets[i]));
        }

        while (!queue.isEmpty()) {
            var pair = queue.poll();
            time++;

            if (pair.getValue() > 1) {
                // Если человеку нужно больше билетов, он идет в конец очереди
                pair = Map.entry(pair.getKey(), pair.getValue() - 1);
                queue.add(pair);
            } else if (pair.getKey() == k) {
                // Если это k-й человек и он купил последний билет
                break;
            }
        }

        return time;
    }
}
