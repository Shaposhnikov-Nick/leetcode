import java.util.HashSet;

public class Solution_202_HappyNumber {
    public static void main(String[] args) {
        var n = 19;
        isHappy(n);
    }

    private static boolean isHappy(int n) {
        var set = new HashSet<Integer>();
        var num = n;

        while (!set.contains(num)) {
            set.add(num);
            num = getSum(num);
            if (num == 1) return true;
        }

        return false;
    }

    private static int getSum(int n) {
        var sum = 0;

        while (n > 0) {
            var digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }
}
