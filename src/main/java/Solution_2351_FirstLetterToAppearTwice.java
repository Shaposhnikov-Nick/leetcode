import java.util.HashSet;

public class Solution_2351_FirstLetterToAppearTwice {
    public static void main(String[] args) {
        var s = "abccbaacz";
        repeatedCharacter(s);
    }

    private static char repeatedCharacter(String s) {
        var chars = new HashSet<Character>();

        for (char ch : s.toCharArray()) {
            if (chars.contains(ch)) return ch;
            chars.add(ch);
        }

        return 'a';
    }
}