import java.util.ArrayDeque;

public class Solution_232_ImplementQueueUsingStacks {
    public static void main(String[] args) {
        var queue = new MyQueueJava();
    }
}

class MyQueueJava {
    ArrayDeque<Integer> queue;

    public MyQueueJava() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        return queue.remove();
    }

    public int peek() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
