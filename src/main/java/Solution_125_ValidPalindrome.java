public class Solution_125_ValidPalindrome {
    public static void main(String[] args) {
        var s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s) {
        var chars = s.toCharArray();
        var left = 0;
        var right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(chars[left])) left++;
            while (left < right && !Character.isLetterOrDigit(chars[right])) right--;
            if (Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) return false;
            left++;
            right--;
        }
        return true;
    }
}


