public class Solution_1160_FindWordsThatCanBeFormedByCharacters {
    public static void main(String[] args) {
        var words = new String[]{"cat", "bt", "hat", "tree"};
        var chars = "atach";
        countCharacters(words, chars);
    }

    /**
     * Считаем количество символов в chars
     * Считаем количество символов в каждом слове
     * Сравниваем количество одинаковых символов в word и chars, если в word символов больше чем в chars то слово нам не подходит
     */
    private static int countCharacters(String[] words, String chars) {
        // массив, в котором подсчитывается количество каждого символа в chars
        var charCount = new int[26];
        var result = 0;

        for (var ch : chars.toCharArray()) {
            // индекс массива - индекс символа
            // значение - количество вхождений в chars
            charCount[ch - 'a']++;
        }

        // проверяем каждое слово
        for (var word : words) {
            // массив, в котором подсчитывается количество каждого символа в word
            var wordCount = new int[26];
            var isApplicable = true;

            for (var ch : word.toCharArray()) {
                // индекс массива - индекс символа
                // значение - количество вхождений в word
                wordCount[ch - 'a']++;
            }

            // сравниваем количество совпадений символов в word и chars
            for (int i = 0; i < 26; i++) {
                // если в слове символов больше чем в chars
                // то слово нам не подходит
                if (wordCount[i] > charCount[i]) {
                    isApplicable = false;
                    break;
                }
            }

            if (isApplicable) result += word.length();
        }

        return result;
    }
}
