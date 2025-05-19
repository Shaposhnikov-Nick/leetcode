public class Solution_189_RotateArray {
    public static void main(String[] args) {
        var nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        var k = 3;
        rotate(nums, k);
    }

    private static void rotate(int[] nums, int k) {
        var steps = k % nums.length;
        revers(nums, 0, nums.length - 1);
        revers(nums, 0, steps - 1);
        revers(nums, steps, nums.length - 1);
    }

    private static void revers(int[] nums, int start, int end) {
        while (start < end) {
            var temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
