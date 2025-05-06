public class Solution_13_RomanToInteger {
    public static void main(String[] args) {
        var s = "MCMXCIV";
        System.out.println(romanToInT(s));
    }

    public static int romanToInT(String s) {
        var result = 0;
        var sArr = s.toCharArray();

        for (int i = 0; i < sArr.length; i++) {
            switch (sArr[i]) {
                case 'I' -> {
                    if (i + 1 <= s.length() - 1 && sArr[i + 1] == 'V') result += 4;
                    else if (i + 1 <= s.length() - 1 && sArr[i + 1] == 'X') result += 9;
                    else result += 1;
                }
                case 'V' -> {
                    if (i > 0 && sArr[i - 1] == 'I') continue;
                    else result += 5;
                }
                case 'X' -> {
                    if (i > 0 && sArr[i - 1] == 'I') continue;
                    else if (i + 1 <= s.length() - 1 && sArr[i + 1] == 'L') result += 40;
                    else if (i + 1 <= s.length() - 1 && sArr[i + 1] == 'C') result += 90;
                    else result += 10;
                }
                case 'L' -> {
                    if (i > 0 && sArr[i - 1] == 'X') continue;
                    else result += 50;
                }

                case 'C' -> {
                    if (i > 0 && sArr[i - 1] == 'X') continue;
                    else if (i + 1 <= s.length() - 1 && sArr[i + 1] == 'D') result += 400;
                    else if (i + 1 <= s.length() - 1 && sArr[i + 1] == 'M') result += 900;
                    else result += 100;
                }

                case 'D' -> {
                    if (i > 0 && sArr[i - 1] == 'C') continue;
                    else result += 500;
                }

                case 'M' -> {
                    if (i > 0 && sArr[i - 1] == 'C') continue;
                    else result += 1000;
                }
            }
        }

        return result;
    }

}