public class Solution_136_SingleNumber {
    public static void main(String[] args) {
        var nums = new int[]{4, 1, 2, 1, 2};
        singleNumber(nums);
    }

    private static int singleNumber(int[] nums) {
        var result = 0;
        for (var num : nums) {
            result = result ^ num;
        }
        return result;
    }
}
