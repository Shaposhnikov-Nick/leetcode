import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution_748_ShortestCompletingWord {
    public static void main(String[] args) {
        var licensePlate = "Ah71752";
        var words = new String[]{"suggest", "letter", "of", "husband", "easy", "education", "drug", "prevent", "writer", "old"};
        System.out.println(shortestCompletingWord(licensePlate, words));
    }

    /**
     * Считаем все буквы в licensePlate, переводя их в нижний регистр
     * Проходим по каждому слову, считаем количество букв в слове
     * Отфильтровываем только те, которые есть в licensePlate, если букв не одинаково с licensePlate, слово не подходит
     * Сравниваем точное количество каждой буквы
     * Если количество букв совпадает и это слово короче, оно будет результатом
     */
    private static String shortestCompletingWord(String licensePlate, String[] words) {
        var charMap = new HashMap<Character, Integer>();
        var minLength = Integer.MAX_VALUE;
        var resultWord = "";

        // Считаем все буквы в licensePlate, переводя их в нижний регистр
        for (var ch : licensePlate.toCharArray()) {
            if (Character.isLetter(ch))
                charMap.merge(Character.toLowerCase(ch), 1, Integer::sum);
        }

        // Проходим по каждому слову
        for (var word : words) {
            // Считаем количество букв в слове
            var wordCharMap = new HashMap<Character, Integer>();
            for (var ch : word.toCharArray()) {
                wordCharMap.merge(Character.toLowerCase(ch), 1, Integer::sum);
            }

            // Отфильтровываем только те, которые есть в licensePlate
            var filteredMap = wordCharMap.entrySet().stream()
                    .filter(entry -> charMap.containsKey(entry.getKey()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            // Если количество букв не одинаково с licensePlate, слово не подходит
            if (filteredMap.size() != charMap.size())
                continue;

            // Сравниваем точное количество каждой буквы
            var isApplicable = true;
            for (var entry : filteredMap.entrySet()) {
                var count = charMap.get(entry.getKey());
                if (count == null || count > entry.getValue()) {
                    isApplicable = false;
                    break;
                }
            }

            // Если количество букв совпадает и это слово короче, оно будет результатом
            if (isApplicable && word.length() < minLength) {
                resultWord = word;
                minLength = word.length();
            }
        }

        return resultWord;
    }
}
