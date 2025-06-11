import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution_49_GroupAnagrams {
    public static void main(String[] args) {
        var strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();
        Arrays.stream(strs).forEach(str -> {
            var chars = str.toCharArray();
            Arrays.sort(chars);
            var sorted = new String(chars);
            map.computeIfAbsent(sorted, v -> new ArrayList<>()).add(str);
        });
        return map.values().stream().toList();
    }
}
