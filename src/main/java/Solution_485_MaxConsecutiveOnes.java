public class Solution_485_MaxConsecutiveOnes {
    public static void main(String[] args) {
        var nums = new int[]{1, 1, 0, 0, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        var maxCount = 0;
        var currentCount = 0;

        for (int num : nums) {
            if (num == 1) {
                currentCount++;
            } else {
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 0;
            }
        }
        return Math.max(maxCount, currentCount);
    }
}
