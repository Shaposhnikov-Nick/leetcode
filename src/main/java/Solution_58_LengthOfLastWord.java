import java.util.Arrays;

public class Solution_58_LengthOfLastWord {
    public static void main(String[] args) {
        var s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
    }

    private static int lengthOfLastWord(String s) {
        var list = s.trim().split(" ");
        return Arrays.stream(list)
                .skip(list.length - 1)
                .findFirst()
                .map(String::length)
                .get();
    }
}
