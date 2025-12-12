import java.util.Arrays;

public class Solution_3688_BitwiseORofEvenNumbersInArray {
    public static void main(String[] args) {
        var nums = new int[]{1, 2, 3, 4, 5, 6};
        evenNumberBitwiseORs(nums);
    }

    private static int evenNumberBitwiseORs(int[] nums) {
        return Arrays.stream(nums)
                .filter(num -> num % 2 == 0)
                .reduce(0, (a, b) -> a | b);
    }
}
