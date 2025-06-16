public class Solution_334_IncreasingTripletSubsequence {
    public static void main(String[] args) {
        var nums = new int[]{20, 100, 10, 12, 5, 13};
        System.out.println(increasingTriplet(nums));
    }

    private static boolean increasingTriplet(int[] nums) {
        var firstMin = Integer.MAX_VALUE;
        var secondMin = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= firstMin)
                firstMin = num;
            else if (num <= secondMin)
                secondMin = num;
            else return true;
        }

        return false;
    }
}
