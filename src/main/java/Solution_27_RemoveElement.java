public class Solution_27_RemoveElement {
    public static void main(String[] args) {
        var nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        var val = 2;
        removeElement(nums, val);
    }

    private static int removeElement(int[] nums, int val) {
        var k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
