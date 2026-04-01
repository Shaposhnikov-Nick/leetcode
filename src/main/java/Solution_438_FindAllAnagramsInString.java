import java.util.*;

public class Solution_438_FindAllAnagramsInString {
    public static void main(String[] args) {
        var s = "cbaebabacd";
        var p = "abc";
        findAnagrams(s, p);
    }

    private static List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) return Collections.emptyList();
        // Мапа для хранения частот символов строки р
        var pMap = new HashMap<Character, Integer>();
        var result = new ArrayList<Integer>();

        // Подсчитываем количество совпадений букв в строке р
        for (var ch : p.toCharArray()) {
            pMap.merge(ch, 1, Integer::sum);
        }

        // Используем скользящее окно размером р для прохода по всей строке от 0
        var windowLength = p.length();
        var windowMap = new HashMap<Character, Integer>();

        // Сначала считаем количество совпадений в первом окне 0 до windowLength
        // В дальнейшем будем менять windowMap, двигая окно
        var sArr = s.toCharArray();
        for (int i = 0; i < windowLength; i++) {
            windowMap.merge(sArr[i], 1, Integer::sum);
        }

        // Проходим по строке s двигая окно
        for (int i = 0; i <= s.length() - windowLength; i++) {
            // чтобы не считать заново символы в каждом окне, удаляем из мапы левое значение и добавляем правое
            if (i != 0) {
                // удаляем левое
                var value = windowMap.merge(sArr[i - 1], -1, Integer::sum);
                if (value < 1) windowMap.remove(sArr[i - 1]);
                // добавляем правое
                windowMap.merge(sArr[i + windowLength - 1], 1, Integer::sum);
            }

            // Если мапа окна соответствует мапе строки р, добавлеям начальный индекс окна в result
            if (windowMap.equals(pMap)) result.add(i);

        }

        return result;
    }
}
