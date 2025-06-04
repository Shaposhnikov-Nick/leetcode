import java.util.Arrays;

public class Solution_977_SquaresOfASortedArray {
    public static void main(String[] args) {
        var nums = new int[]{-5, -4, -3, -2, -1};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    private static int[] sortedSquares(int[] nums) {
        var squareNums = new int[nums.length];
        var squareNumsIndex = squareNums.length - 1;
        var left = 0;
        var right = nums.length - 1;

        while (squareNumsIndex >= 0) {
            var leftSquare = nums[left] * nums[left];
            var rightSquare = nums[right] * nums[right];
            if (leftSquare > rightSquare) {
                squareNums[squareNumsIndex--] = leftSquare;
                left++;
            } else {
                squareNums[squareNumsIndex--] = rightSquare;
                right--;
            }
        }

        return squareNums;
    }
}
