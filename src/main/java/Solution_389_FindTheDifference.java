import java.util.HashMap;

public class Solution_389_FindTheDifference {
    public static void main(String[] args) {
        var s = "abcd";
        var t = "abcde";
        findTheDifference(s, t);
    }

    private static char findTheDifference(String s, String t) {
        var map = new HashMap<Character, Integer>();

        // считаем количество совпадений символов в строке
        for (var ch : t.toCharArray()) {
            map.compute(ch, (kew, value) -> (value == null ? 0 : value) + 1);
        }

        // вычитаем втрую строку
        for (var ch : s.toCharArray()) {
            map.merge(ch, 1, (oldValue, newValue) -> oldValue - newValue);
        }

        // возвращаем единственный символ, количество которого равно 1
        return map.entrySet().stream().filter(entry -> entry.getValue() == 1)
                .findFirst()
                .get()
                .getKey();
    }
}
