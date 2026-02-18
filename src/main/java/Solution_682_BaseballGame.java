import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution_682_BaseballGame {
    public static void main(String[] args) {
        var ops = new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"};
        calPoints(ops);
    }

    private static int calPoints(String[] operations) {
        var result = new ArrayDeque<Integer>();

        Arrays.stream(operations).forEach(op -> {
            switch (op) {
                case "+" -> {
                    var last1 = result.pop();
                    var last2 = result.peek();
                    result.push(last1);
                    result.push(last1 + last2);
                }
                case "C" -> result.pop();
                case "D" -> result.push(result.peek() * 2);
                default -> result.push(Integer.valueOf(op));
            }
        });

        return result.stream().reduce(0, Integer::sum);
    }
}
