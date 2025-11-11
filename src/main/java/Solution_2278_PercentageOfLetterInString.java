public class Solution_2278_PercentageOfLetterInString {
    public static void main(String[] args) {
        var s = "foobar";
        var letter = 'o';
        System.out.println(percentageLetter(s, letter));
    }

    private static int percentageLetter(String s, char letter) {
        var count = s.chars().filter(c -> c == letter).count();
        return (int) (count * 100 / s.length());
    }
}
