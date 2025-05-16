public class Solution_283_MoveZeroes {
    public static void main(String[] args) {
        var nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
    }

    private static void moveZeroes(int[] nums) {
        var writeIndex = 0;
        for (int readIndex = 0; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != 0) {
                nums[writeIndex] = nums[readIndex];
                if (readIndex > writeIndex) nums[readIndex] = 0;
                writeIndex++;
            }
        }
    }
}
