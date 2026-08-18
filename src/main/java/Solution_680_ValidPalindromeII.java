public class Solution_680_ValidPalindromeII {
    public static void main(String[] args) {
        var s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        validPalindrome(s);
    }

    /**
     * Проходим по строке с обоих концов навстречу и сравниваем символы.
     * Если доходим до первого несовпадения символов, пробуем удалить символ в начале или символ в конце
     * и проверить оставшуюся строку на палиндром. Если хотя бы одна подстрока после удаления одного символа  является палиндромом,
     * возвращаем true, иначе false
     */
    private static boolean validPalindrome(String s) {
        var l = 0;
        var r = s.length() - 1;

        // Проходим по строке с обоих концов навстречу и сравниваем символы.
        while (l < r) {
            // Если доходим до первого несовпадения символов, пробуем удалить символ в начале или символ в конце
            if (s.charAt(l) != s.charAt(r)) {
                // проверяем оставшуюся строку на палиндром
                // Если хотя бы одна подстрока после удаления одного символа  является палиндромом, возвращаем true, иначе false
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
            l++;
            r--;
        }

        return true;
    }

    // проверят, что строка - палиндром
    private static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }

        return true;
    }
}
