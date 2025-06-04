public class Solution_1295_FindNumbersWithEvenNumberOfDigits {
    public static void main(String[] args) {
        var nums = new int[]{12, 345, 2, 6, 7896};
        System.out.println(findNumbers(nums));
    }

    private static int findNumbers(int[] nums) {
        var countDigits = 1;
        var countNumbers = 0;

        for (int num : nums) {
            var currentNum = num;
            while (currentNum >= 10) {
                countDigits++;
                currentNum /= 10;
            }
            if (countDigits % 2 == 0) countNumbers++;
            countDigits = 1;
        }
        return countNumbers;
    }
}
