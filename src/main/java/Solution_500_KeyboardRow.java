import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_500_KeyboardRow {
    public static void main(String[] args) {
        var words = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        findWords(words);
    }

    private static String[] findWords(String[] words) {
        var set1 = new HashSet<Character>();
        var set2 = new HashSet<Character>();
        var set3 = new HashSet<Character>();
        var result = new ArrayList<String>();

        for (var ch : "qwertyuiop".toCharArray()) {
            set1.add(ch);
        }
        for (var ch : "asdfghjkl".toCharArray()) {
            set2.add(ch);
        }
        for (var ch : "zxcvbnm".toCharArray()) {
            set3.add(ch);
        }

        Arrays.stream(words).forEach(word -> {
            if (checkWordInSet(word, set1) || checkWordInSet(word, set2) || checkWordInSet(word, set3))
                result.add(word);
        });

        return result.toArray(new String[0]);
    }

    private static boolean checkWordInSet(String word, Set<Character> set) {
        for (var ch : word.toCharArray()) {
            if (!set.contains(Character.toLowerCase(ch))) return false;
        }
        return true;
    }
}
