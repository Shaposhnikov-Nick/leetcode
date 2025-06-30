import java.util.ArrayDeque;

public class Solution_2390_RemovingStarsFromString {
    public static void main(String[] args) {
        var s = "leet**cod*e";
        System.out.println(removeStars(s));
    }

    private static String removeStars(String s) {
        var stack = new ArrayDeque<Character>();

        for (Character ch : s.toCharArray()) {
            if (!ch.equals('*')) stack.push(ch);
            else stack.pop();
        }

        var builder = new StringBuilder();

        while (!stack.isEmpty()) {
            builder.append(stack.removeLast());
        }

        return builder.toString();
    }
}
