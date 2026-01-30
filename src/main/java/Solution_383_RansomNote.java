import java.util.HashMap;

public class Solution_383_RansomNote {
    public static void main(String[] args) {
        var ransomNote = "aa";
        var magazine = "ab";
        canConstruct(ransomNote, magazine);
    }

    private static boolean canConstruct(String ransomNote, String magazine) {
        var lettersCount = new HashMap<Character, Integer>();

        for (var letter : magazine.toCharArray()) {
            lettersCount.merge(letter, 1, Integer::sum);
//            lettersCount.merge(letter, 1, (oldValue, newValue) -> oldValue + newValue);
//            lettersCount.compute(letter, (key, value) -> value == null ? 1 : value + 1);
//            lettersCount.put(letter, lettersCount.getOrDefault(letter, 0) + 1);
        }

        for (var letter : ransomNote.toCharArray()) {
            var count = lettersCount.get(letter);
            if (count == null || count == 0) return false;
            lettersCount.compute(letter, (key, value) -> value - 1);
        }

        return true;
    }
}
