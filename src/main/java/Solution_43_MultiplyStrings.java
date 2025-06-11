public class Solution_43_MultiplyStrings {
    public static void main(String[] args) {
        var num1 = "2";
        var num2 = "3";
        System.out.println(multiply(num1, num2));
    }

    private static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];

        // Multiply each digit of num1 with each digit of num2
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = product + result[i + j + 1];

                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        // Convert the result array to a string, skipping leading zeros
        var sb = new StringBuilder();
        for (int digit : result) {
            if (!sb.isEmpty() || digit != 0) {
                sb.append(digit);
            }
        }

        return sb.toString();
    }
}
