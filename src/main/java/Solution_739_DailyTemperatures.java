import java.util.ArrayDeque;

public class Solution_739_DailyTemperatures {
    public static void main(String[] args) {
        var temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        dailyTemperatures(temperatures);
    }

    private static int[] dailyTemperatures(int[] temperatures) {
        var result = new int[temperatures.length];
        var stack = new ArrayDeque<Integer>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                var prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return result;
    }
}
