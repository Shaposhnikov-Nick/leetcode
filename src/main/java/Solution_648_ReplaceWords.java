import java.util.HashSet;
import java.util.List;

public class Solution_648_ReplaceWords {
    public static void main(String[] args) {
        var dictionary = List.of("cat", "bat", "rat");
        var sentence = "the cattle was rattled by the battery";
        replaceWords(dictionary, sentence);
    }

    /**
     * Через Хеш-сет (Простой и интуитивный)
     * Подготовка: Помещаем все корни из dictionary в хеш-сет (HashSet / Set). Это позволяет проверять наличие корня
     * за время $O(1)$ в среднем.
     * <p>
     * Разбиение предложения: Разбиваем строку sentence на отдельные слова по пробелам.
     * Обработка каждого слова: Для текущего слова перебираем все его префиксы, начиная с длины 1 и увеличивая длину на единицу:
     * Для слова cattle: проверяем префикс c, затем ca, затем cat и так далее.
     * На каждом шаге проверяем: есть ли такой префикс в нашем сете? Как только находим первое совпадение, сразу останавливаемся —
     * так как мы идем от меньшей длины к большей, первый найденный корень гарантированно будет самым коротким.
     * Если дошли до конца слова и совпадений не нашли, оставляем исходное слово.Сборка результата: Соединяем обработанные слова обратно через пробел.
     */
    private static String replaceWords(List<String> dictionary, String sentence) {
        var result = new StringBuilder();
        var roots = new HashSet<String>(dictionary);
        var words = sentence.split(" ");

        for (var word : words) {
            var hasRoot = false;
            for (int i = 1; i < word.length(); i++) {
                var subStr = word.substring(0, i);
                // если часть слова есть в списке корней
                if (roots.contains(subStr)) {
                    // добавляем корень в результат
                    result.append(subStr);
                    result.append(" ");
                    hasRoot = true;
                    break;
                }
            }

            // если корня нет, добавляем все слово в результат
            if (!hasRoot) {
                result.append(word);
                result.append(" ");
            }
        }

        return result.toString().trim();
    }
}
