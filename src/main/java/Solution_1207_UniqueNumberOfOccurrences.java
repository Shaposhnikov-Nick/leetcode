import java.util.*;

public class Solution_1207_UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        var arr = new int[]{1, 2, 2, 1, 1, 3, 2};
        System.out.println(uniqueOccurrences(arr));
    }

    private static boolean uniqueOccurrences(int[] arr) {
        var map = new HashMap<Integer, Integer>();

        Arrays.stream(arr).forEach(num -> {
            map.compute(num, (key, value) -> value == null ? 0 : value + 1);
        });

        var unique = new HashSet<>(map.values());

        return unique.size() == map.size();
    }
}
