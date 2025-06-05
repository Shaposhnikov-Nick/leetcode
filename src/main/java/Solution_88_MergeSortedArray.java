public class Solution_88_MergeSortedArray {
    public static void main(String[] args) {
        var nums1 = new int[]{1, 2, 3, 0, 0, 0};
        var m = 3;
        var nums2 = new int[]{2, 5, 6};
        var n = 3;
        merge(nums1, m, nums2, n);
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        var nums1Index = 0;

        for (int nums2Index = 0; nums2Index < nums2.length; nums2Index++) {
            while (nums2[nums2Index] > nums1[nums1Index] && nums1Index < m + nums2Index) {
                nums1Index++;
            }

            var mIndex = m + nums2Index - 1;
            if (nums1Index <= mIndex) {
                for (int i = mIndex; i >= nums1Index; i--) {
                    nums1[i + 1] = nums1[i];
                }
            }
            nums1[nums1Index] = nums2[nums2Index];
        }
    }
}
