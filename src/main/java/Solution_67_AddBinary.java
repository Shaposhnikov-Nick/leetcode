public class Solution_67_AddBinary {
    public static void main(String[] args) {
        var a = "1010";
        var b = "1011";
        addBinary(a, b);
    }

    private static String addBinary(String a, String b) {
        var result = new StringBuilder();
        var aIndex = a.length() - 1;
        var bIndex = b.length() - 1;
        var carry = 0;
        var aArr = a.toCharArray();
        var bArr = b.toCharArray();

        while (aIndex >= 0 || bIndex >= 0 || carry > 0) {
            var aDigit = 0;
            var bDigit = 0;
            var newDigit = 0;

            if (aIndex >= 0) aDigit = aArr[aIndex] - '0';
            if (bIndex >= 0) bDigit = bArr[bIndex] - '0';

            var sum = aDigit + bDigit + carry;

            if (sum == 0 || sum == 2) newDigit = 0;
            else newDigit = 1;

            if (sum >= 2) carry = 1;
            else carry = 0;

            result.append(newDigit);

            aIndex--;
            bIndex--;
        }

        return result.reverse().toString();
    }
}
