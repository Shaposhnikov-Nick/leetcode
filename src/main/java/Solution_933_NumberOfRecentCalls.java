import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_933_NumberOfRecentCalls {
    public static void main(String[] args) {
        var recentCounter = new RecentCounter2();
        recentCounter.ping(1);
        recentCounter.ping(100);
        recentCounter.ping(3001);
        recentCounter.ping(3002);
    }
}

class RecentCounter2 {
    Deque<Integer> queue;

    public RecentCounter2() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.push(t);

        while (queue.peekLast() != null && queue.peekLast() < t - 3000) {
            queue.removeLast();
        }

        return queue.size();
    }
}
