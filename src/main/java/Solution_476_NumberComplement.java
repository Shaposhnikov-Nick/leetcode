public class Solution_476_NumberComplement {
    public static void main(String[] args) {
        var num = 5;
        findComplement(num);
    }

    /**
     * Переводим число в двоичную систему счисления сразу изменяя 0 на 1 и 1 на 0
     * Переводим получившееся двоичное число обратно в десятичное
     */
    private static int findComplement(int num) {
        var sb = new StringBuilder();

        // Переводим число в двоичную систему счисления сразу изменяя 0 на 1 и 1 на 0
        while (num != 0) {
            var remainder = num % 2;
            if (remainder == 0) sb.insert(0, 1);
            else sb.insert(0, 0);
            num /= 2;
        }

        var binary = sb.toString();
        var result = 0.0;

        // Переводим получившееся двоичное число обратно в десятичное
        for (int i = 0; i < binary.length(); i++) {
            var degree = Math.pow(2.0, i);
            var bit = binary.charAt(binary.length() - 1 - i);
            result += Character.getNumericValue(bit) * degree;
        }

        return (int) result;
    }
}
