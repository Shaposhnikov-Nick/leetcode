public class Solution_66_PlusOne {
    public static void main(String[] args) {
        var digits = new int[]{1, 2, 3};
        plusOne(digits);
    }

    private static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        var result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
