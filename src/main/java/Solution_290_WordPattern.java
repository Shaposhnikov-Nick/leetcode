import java.util.HashMap;

public class Solution_290_WordPattern {
    public static void main(String[] args) {
        var pattern = "abba";
        var s = "dog dog dog dog";
        wordPattern(pattern, s);
    }

    /**
     * Проверяем кажду букву в паттерне с соответствующим ему словом
     * Если соответствующей букве паттерна уже назначено другое слово, возвращаем false
     */
    private static boolean wordPattern(String pattern, String s) {
        // Мапа для хранения паттерн - слово
        var map = new HashMap<Character, String>();
        var patternArr = pattern.toCharArray();
        var sArr = s.split(" ");

        // если длина букв паттерна не совпадает с количеством слов в строке то false
        if (sArr.length != patternArr.length) return false;

        // сравниваем попарно букву паттерна и слово из строки
        for (int i = 0; i < patternArr.length; i++) {
            var p = patternArr[i];
            var word = sArr[i];
            // проверяем, если ли уже слово для паттерна в мапе
            var value = map.get(p);
            // если слова еще нет и такого слова вообще нет ни для какой другой буквы паттерна, добавляем пару в мапу
            if (value == null && !map.containsValue(word)) map.put(p, word);
                // если слово для паттерна уже есть, проверяем, совпадают ли они
            else if (!word.equals(value)) return false;
        }

        return true;
    }
}
