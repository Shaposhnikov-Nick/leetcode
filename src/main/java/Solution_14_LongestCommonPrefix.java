import java.util.Arrays;
import java.util.Comparator;

public class Solution_14_LongestCommonPrefix {
    public static void main(String[] args) {
        var strs = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        var shortest = Arrays.stream(strs).min(Comparator.comparingInt(String::length)).get();

        for (int i = 0; i < shortest.length(); i++) {
            var ch = shortest.charAt(i);
            var finalI = i;
            if (Arrays.stream(strs).anyMatch(s -> s.charAt(finalI) != ch)) {
                return shortest.substring(0, i);
            }
        }

        return shortest;
    }
}
