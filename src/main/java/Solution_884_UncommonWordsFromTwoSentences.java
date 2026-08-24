import java.util.HashMap;
import java.util.Map;

public class Solution_884_UncommonWordsFromTwoSentences {
    public static void main(String[] args) {
        var s1 = "this apple is sweet";
        var s2 = "this apple is sour";
        uncommonFromSentences(s1, s2);
    }

    /**
     * Добавляем слова из первого и второго предложения в мапу, подсчитывая количество совпадающих слов.
     * Возвращаем список слов, которые встретились один раз
     */
    private static String[] uncommonFromSentences(String s1, String s2) {
        var frequencyMap = new HashMap<String, Integer>();

        for (var word : s1.split(" ")) {
            frequencyMap.merge(word, 1, Integer::sum);
        }

        for (var word : s2.split(" ")) {
            frequencyMap.merge(word, 1, Integer::sum);
        }

        return frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
    }
}
