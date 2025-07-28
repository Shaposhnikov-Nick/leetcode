import java.util.HashSet;

public class Solution_128_LongestConsecutiveSequence {
    public static void main(String[] args) {
        var nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    private static int longestConsecutive(int[] nums) {
        var longest = 0;
        var numsSet = new HashSet<Integer>(nums.length);
        for (int num : nums) {
            numsSet.add(num);
        }

        for (int num : numsSet) {
            if (!numsSet.contains(num - 1)) {
                var currentNum = num;
                var currentLongest = 1;

                while (numsSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLongest++;
                }
                longest = Math.max(longest, currentLongest);
            }
        }

        return longest;
    }
}
