import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution_557_ReverseWordsInStringIII {
    public static void main(String[] args) {
        var s = "Let's take LeetCode contest";
        reverseWords(s);
    }

    /**
     * Делим на отдельны слова по пробелам
     * Меняем порядок символов в каждом слове
     * Объединяем слова в новую строку
     */
    private static String reverseWords(String s) {
        return Arrays.stream(s.split(" ")) // Делим на отдельны слова по пробелам
                .map(str -> {
                    // Меняем порядок символов в каждом слове
                    var arr = str.toCharArray();
                    for (int i = 0; i < arr.length / 2; i++) {
                        var temp = arr[i];
                        arr[i] = arr[arr.length - 1 - i];
                        arr[arr.length - 1 - i] = temp;
                    }
                    return new String(arr);
                }).collect(Collectors.joining(" ")); // Объединяем слова в новую строку
    }
}
