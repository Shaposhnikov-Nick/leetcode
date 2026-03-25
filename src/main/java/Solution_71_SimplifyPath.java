import java.util.ArrayDeque;

public class Solution_71_SimplifyPath {
    public static void main(String[] args) {
        var path = "/.../a/../b/c/../d/./";
        simplifyPath(path);
    }

    private static String simplifyPath(String path) {
        var initial = new ArrayDeque<String>();
        var result = new ArrayDeque<String>();
        var words = path.split("/");

        for (var word : words) {
            if (!word.isEmpty()) initial.addLast(word);
        }

        while (!initial.isEmpty()) {
            var segment = initial.removeFirst();

            if (!segment.equals(".") && !segment.equals("..")) {
                result.addLast("/");
                result.addLast(segment);
            } else if (segment.equals("..")) {
                if (!result.isEmpty()) {
                    result.removeLast();
                    result.removeLast();
                }
            }
        }

        return result.isEmpty() ? "/" : String.join("", result);
    }
}
