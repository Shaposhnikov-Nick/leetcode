public class Solution_647_PalindromicSubstrings {
    public static void main(String[] args) {
        var s = "abc";
        countSubstrings(s);
    }

    private static int countSubstrings(String s) {
        int count = 0;
        int n = s.length();

        // Перебираем все возможные центры
        for (int i = 0; i < n; i++) {
            // Случай 1: нечетные палиндромы (центр - одиночный символ)
            count += expandAroundCenter(s, i, i);

            // Случай 2: четные палиндромы (центр - между двумя символами)
            if (i < n - 1) {
                count += expandAroundCenter(s, i, i + 1);
            }
        }

        return count;
    }

    // Функция расширения от центра
    // Возвращает количество палиндромов, найденных при расширении от данного центра
    private static int expandAroundCenter(String s, int left, int right) {
        int count = 0;
        int l = left;
        int r = right;

        // Расширяемся, пока не вышли за границы и символы совпадают
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++; // Нашли новый палиндром
            l--; // Расширяемся влево
            r++; // Расширяемся вправо
        }

        return count;
    }
}
