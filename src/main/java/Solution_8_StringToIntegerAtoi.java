import java.math.BigInteger;

public class Solution_8_StringToIntegerAtoi {
    public static void main(String[] args) {
        var s = "-91283472332";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        var trimmed = s.trim();
        if (trimmed.isEmpty()) return 0;

        var sign = 0;
        if (trimmed.charAt(0) == '-') sign = -1;
        else if (trimmed.charAt(0) == '+') sign = 1;

        var startIndex = 0;
        if (sign != 0) startIndex = 1;

        var builder = new StringBuilder();

        for (int i = startIndex; i < trimmed.length(); i++) {
            if (Character.isDigit(trimmed.charAt(i))) builder.append(trimmed.charAt(i));
            else break;
        }
        if (builder.isEmpty()) return 0;

        var resultString = "";
        if (sign == -1) resultString = builder.insert(0, "-").toString();
        else resultString = builder.toString();

        var number = new BigInteger(resultString);
        var result = 0;

        if (number.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) > 0) result = Integer.MAX_VALUE;
        else if (number.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) < 0) result = Integer.MIN_VALUE;
        else result = Integer.parseInt(number.toString());

        return result;
    }
}
