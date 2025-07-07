import java.util.*;

public class Solution_2215_FindTheDifferenceOfTwoArrays {
    public static void main(String[] args) {
        var nums1 = new int[]{1, 2, 3};
        var nums2 = new int[]{2, 4, 6};
        System.out.println(findDifference(nums1, nums2));
    }

    private static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        var result = new ArrayList<List<Integer>>();
        var nums1result = new HashSet<Integer>();
        var nums2result = new HashSet<Integer>();
        var nums1Map = new HashMap<Integer, Integer>();
        var nums2Map = new HashMap<Integer, Integer>();

        Arrays.stream(nums1).forEach(num -> nums1Map.put(num, num));
        Arrays.stream(nums2).forEach(num -> nums2Map.put(num, num));

        Arrays.stream(nums1).forEach(num -> {
            if (nums2Map.get(num) == null) nums1result.add(num);
        });

        Arrays.stream(nums2).forEach(num -> {
            if (nums1Map.get(num) == null) nums2result.add(num);
        });

        result.add(new ArrayList<>(nums1result));
        result.add(new ArrayList<>(nums2result));

        return result;
    }
}
