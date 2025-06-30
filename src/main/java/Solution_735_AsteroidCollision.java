import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution_735_AsteroidCollision {
    public static void main(String[] args) {
        var asteroids = new int[]{5, 10, -5, 7, -14, 8};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    private static int[] asteroidCollision(int[] asteroids) {
        var stack = new ArrayDeque<Integer>();

        for (int asteroid : asteroids) {
            if (stack.isEmpty() || asteroid > 0) {
                stack.addLast(asteroid);
            } else {
                while (true) {
                    var top = stack.peekLast();
                    if (top == null || top < 0) {
                        stack.addLast(asteroid);
                        break;
                    } else if (top == -asteroid) {
                        stack.removeLast();
                        break;
                    } else if (top > -asteroid) {
                        break;
                    } else stack.removeLast();
                }
            }
        }

        var result = new int[stack.size()];
        var i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }

        return result;
    }
}
