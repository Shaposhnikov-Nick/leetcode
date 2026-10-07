import java.util.HashSet;

public class Solution_804_UniqueMorseCodeWords {
    public static void main(String[] args) {
        var words = new String[]{"gin", "zen", "gig", "msg"};
        uniqueMorseRepresentations(words);
    }

    /**
     * Проходим по каждому слову, каждый символ преобразовываем в код морзе
     * Получившийся общий код добавляем в set
     * Возвращаем размер сета
     */
    private static int uniqueMorseRepresentations(String[] words) {
        var morseDictionary = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        var set = new HashSet<String>();

        // Проходим по каждому слову
        for (var word : words) {
            var sb = new StringBuilder();
            // каждый символ преобразовываем в код морзе
            for (var c : word.toCharArray()) {
                var index = c - 'a';
                var morseCode = morseDictionary[index];
                sb.append(morseCode);
            }
            set.add(sb.toString());
        }

        return set.size();
    }
}
