import java.util.HashSet;

public class Solution_349_IntersectionOfTwoArrays {
    public static void main(String[] args) {
        var nums1 = new int[]{4, 9, 5};
        var nums2 = new int[]{9, 4, 9, 8, 4};
        intersection(nums1, nums2);
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        var resultSet = new HashSet<Integer>();
        var setNums1 = new HashSet<Integer>();

        for (var num : nums1) {
            setNums1.add(num);
        }

        for (var num : nums2) {
            if (setNums1.contains(num)) resultSet.add(num);
        }

        return resultSet.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    // Convert set to array
//    int[] result = new int[resultSet.size()];
//    int i = 0;
//        for (int num : resultSet) {
//        result[i++] = num;
//    }
}

