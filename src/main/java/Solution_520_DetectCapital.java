import javax.xml.stream.events.Characters;

public class Solution_520_DetectCapital {
    public static void main(String[] args) {
        var word = "Flag";
        System.out.println(detectCapitalUse(word));
    }

    private static boolean detectCapitalUse(String word) {
        var capital = 0;
        var wordArr = word.toCharArray();

        // считаем заглавные буквы
        for (Character letter : wordArr) {
            if (Character.toUpperCase(letter) == letter) {
                capital++;
            }
        }

        return capital == 0 || (capital == 1 && Character.toUpperCase(wordArr[0]) == wordArr[0]) || word.length() == capital;
    }
}
