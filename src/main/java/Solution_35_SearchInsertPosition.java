public class Solution_35_SearchInsertPosition {
    public static void main(String[] args) {
        var nums = new int[]{1, 3, 5, 6};
        var target = 5;
        System.out.println(searchInsert(nums, target));
    }

    private static int searchInsert(int[] nums, int target) {
        var lo = 0;
        var hi = nums.length - 1;
        while (lo <= hi) {
            var mid = (lo + hi) / 2;
            if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
