import java.util.ArrayList;

public class Solution_9_PalindromeNumber {
    public static void main(String[] args) {
        var x = 1211;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        var digits = new ArrayList<Integer>();

        while (x != 0) {
            var digit = x % 10;
            digits.add(digit);
            x /= 10;
        }

        for (int i = 0; i < digits.size() / 2; i++) {
            if (digits.get(i) != digits.get(digits.size() - 1 - i)) return false;
        }

        return true;
    }
}
