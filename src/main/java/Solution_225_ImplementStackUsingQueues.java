import java.util.ArrayDeque;

public class Solution_225_ImplementStackUsingQueues {
    public static void main(String[] args) {

    }
}

class MyStackJava {

    ArrayDeque<Integer> stack;

    public MyStackJava() {
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}