public class Solution_345_ReverseVowelsOfString {
    public static void main(String[] args) {
        var s = "IceCreAm";
        System.out.println(reverseVowels(s));
    }

    private static String reverseVowels(String s) {
        var arr = s.toCharArray();
        var left = 0;
        var right = arr.length - 1;
        while (left < right) {
            while (left < right && isVowel(arr[left])) left++;
            while (left < right && isVowel(arr[right])) right--;
            var temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }

    private static boolean isVowel(char ch) {
        var vowels = new char[]{'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'};
        for (char vowel : vowels) {
            if (ch == vowel) return true;
        }
        return false;
    }
}
