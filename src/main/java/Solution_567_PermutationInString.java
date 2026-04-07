import java.util.HashMap;

public class Solution_567_PermutationInString {
    public static void main(String[] args) {
        var s1 = "ab";
        var s2 = "eidbaooo";
        checkInclusion(s1, s2);
    }

    /**
     * Создаем Map для хранения частот символов в строке s1 и в каждой подстроке s2
     * Проходим по s2 начиная с 1 индекса и удаляем из скользящего окна предыдущий символ и
     * добавляем следующий, чтобы не пересчитывать полностью s2Map при каждом передвижении окна
     * Если символы и их колиество совпали, возвращаем true
     *
     */
    private static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        if (s1.equals(s2)) return true;

        // Создаем Map для хранения частот символов в строке s1 и в каждой подстроке s2
        var s1Map = new HashMap<Character, Integer>();
        var s2Map = new HashMap<Character, Integer>();

        var windowLength = s1.length();
        var s1Arr = s1.toCharArray();
        var s2Arr = s2.toCharArray();

        // Заполняем мапы
        for (int i = 0; i < windowLength; i++) {
            s2Map.merge(s2Arr[i], 1, Integer::sum);
        }

        for (char c : s1Arr) {
            s1Map.merge(c, 1, Integer::sum);
        }

        if (s1Map.equals(s2Map)) return true;

        // Проходим по s2 начиная с 1 индекса и  удаляем из скользящего окна предыдущий символ
        // добавляем следующий, чтобы не пересчитывать полностью s2Map при каждом передвижении окна
        // Если символы и их колиество совпали, возвращаем true
        for (int i = 1; i < s2.length() - windowLength + 1; i++) {
            // удаляем из скользящего окна предыдущий символ
            var count = s2Map.merge(s2Arr[i - 1], -1, Integer::sum);
            if (count < 1) s2Map.remove(s2Arr[i - 1]);
            // добавляем следующий символ
            s2Map.merge(s2Arr[i + windowLength - 1], 1, Integer::sum);
            // Если символы и их количество совпали, возвращаем true
            if (s1Map.equals(s2Map)) return true;
        }

        return false;
    }
}
