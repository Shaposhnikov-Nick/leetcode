public class Solution_1991_FindTheMiddleIndexInArray {
    public static void main(String[] args) {
        var nums = new int[]{1, 7, 3, 6, 5, 6};
        System.out.println(findMiddleIndex(nums));
    }

    private static int findMiddleIndex(int[] nums) {
        var leftSum = 0;
        var sum = 0;

        for (int num : nums) {
            sum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i])
                return i;
            leftSum += nums[i];
        }

        return -1;
    }
}
