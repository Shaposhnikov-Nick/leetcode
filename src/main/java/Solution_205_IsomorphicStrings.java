import java.util.HashMap;

public class Solution_205_IsomorphicStrings {
    public static void main(String[] args) {
        var s = "badc";
        var t = "baba";
        ;
        isIsomorphic(s, t);
    }

    private static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        var map = new HashMap<Character, Character>();

        var sArr = s.toCharArray();
        var tArr = t.toCharArray();

        for (int i = 0; i < sArr.length; i++) {
            var sChar = sArr[i];
            var tChar = tArr[i];
            var value = map.get(sChar);

            if (value == null && !map.containsValue(tChar))
                map.put(sChar, tChar);
            else if (value != null && tChar != value)
                return false;
            else if (value == null && map.containsValue(tChar))
                return false;
        }

        return true;
    }
}
