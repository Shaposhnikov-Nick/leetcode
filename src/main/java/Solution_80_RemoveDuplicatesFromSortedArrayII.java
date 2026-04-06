public class Solution_80_RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        var nums = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 2, 3, 3};
        removeDuplicates(nums);
    }

    private static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int j = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[j - 2]) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }
}
