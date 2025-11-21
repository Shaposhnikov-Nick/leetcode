public class Solution_415_AddStrings {
    public static void main(String[] args) {
        var num1 = "456";
        var num2 = "77";
        addStrings(num1, num2);
    }

    private static String addStrings(String num1, String num2) {
        var builder = new StringBuilder();
        var num1Index = num1.length() - 1;
        var num2Index = num2.length() - 1;
        var carry = 0;
        var num1Arr = num1.toCharArray();
        var num2Arr = num2.toCharArray();

        while (num1Index >= 0 || num2Index >= 0 || carry > 0) {
            var num1Digit = 0;
            var num2Digit = 0;
            var newDigit = 0;

            if (num1Index >= 0) num1Digit = num1Arr[num1Index] - '0';
            if (num2Index >= 0) num2Digit = num2Arr[num2Index] - '0';

            var sum = num1Digit + num2Digit + carry;

            if (sum > 9) newDigit = sum % 10;
            else newDigit = sum;

            carry = sum / 10;

            builder.append(newDigit);

            num1Index--;
            num2Index--;
        }

        return builder.reverse().toString();
    }
}
