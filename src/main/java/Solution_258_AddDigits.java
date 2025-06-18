public class Solution_258_AddDigits {
    public static void main(String[] args) {
        var num = 38;
        System.out.println(addDigits(num));
    }

    private static int addDigits(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }
}
