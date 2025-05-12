import java.util.HashMap;

public class Solution_242_ValidAnagram {
    public static void main(String[] args) {
        var s = "aacc";
        var t = "ccac";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        var map = new HashMap<Character, Integer>();
        var sArr = s.toCharArray();
        var tArr = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            map.put(sArr[i], map.getOrDefault(sArr[i], 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            var count = map.get(tArr[i]);
            if (count == null || count == 0) return false;
            map.put(tArr[i], --count);
        }

        return true;
    }
}
