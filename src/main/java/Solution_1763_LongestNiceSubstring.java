import java.util.HashMap;

public class Solution_1763_LongestNiceSubstring {
    public static void main(String[] args) {
        var s = "Bb";
        longestNiceSubstring(s);
    }

    /**
     * Идём от больших длин к меньшим - так мы найдём самую длинную подстроку быстрее и можем сразу вернуть результат.
     * Перебираем все возможные длины подстрок (от длины строки до 2).
     * Для каждой длины подстроки вначале считаем первое окно, затем сразу его проверяем.
     * Далее двигаем окно, удаляем левый элемент, добавляем правый и проверяем получившуюся подстроку.
     */
    private static String longestNiceSubstring(String s) {
        if (s == null || s.length() < 2) return "";

        var longestSubStr = "";
        var sArr = s.toCharArray();

        // Перебираем все возможные длины подстрок (от длины строки до 2)
        for (int substrLength = s.length(); substrLength >= 2; substrLength--) {
            var map = new HashMap<Character, Integer>();

            // Инициализация первого окна
            for (int i = 0; i < substrLength; i++) {
                map.merge(sArr[i], 1, Integer::sum);
            }

            // Проверка первого окна
            if (isNiceSubstring(map)) {
                longestSubStr = s.substring(0, substrLength);
                return longestSubStr; // Можно сразу вернуть, т.к. ищем максимальную длину
            }

            // Сдвигаем окно
            for (int left = 1; left + substrLength <= s.length(); left++) {
                int right = left + substrLength - 1;

                // Удаляем левый символ
                char charToRemove = sArr[left - 1];
                map.merge(charToRemove, -1, Integer::sum);
                if (map.get(charToRemove) <= 0) map.remove(charToRemove);

                // Добавляем правый символ
                char charToAdd = sArr[right];
                map.merge(charToAdd, 1, Integer::sum);

                // Проверяем текущее окно
                if (isNiceSubstring(map)) {
                    longestSubStr = s.substring(left, right + 1);
                    return longestSubStr; // Нашли максимальную длину
                }
            }
        }

        return longestSubStr;
    }

    // Выносим проверку в отдельный метод для чистоты кода
    private static boolean isNiceSubstring(HashMap<Character, Integer> map) {
        for (char ch : map.keySet()) {
            if (Character.isLowerCase(ch) && !map.containsKey(Character.toUpperCase(ch))) {
                return false;
            }
            if (Character.isUpperCase(ch) && !map.containsKey(Character.toLowerCase(ch))) {
                return false;
            }
        }
        return true;
    }
}
