public class Solution_167_TwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
        var numbers = new int[]{2, 7, 11, 15};
        var target = 9;
        twoSum(numbers, target);
    }

    private static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            var firstValue = numbers[i];
            var searchValue = target - firstValue;
            var searchValueIndex = binarySearch(numbers, i + 1, numbers.length - 1, searchValue);
            if (searchValueIndex != -1) return new int[]{i + 1, searchValueIndex + 1};
        }

        return new int[]{};
    }

    private static int binarySearch(int[] numbers, int startIndex, int endIndex, int searchValue) {
        if (startIndex > endIndex) return -1;
        if (startIndex == endIndex) return numbers[startIndex] == searchValue ? startIndex : -1;

        var midIndex = startIndex + (endIndex - startIndex) / 2;
        var midIndexValue = numbers[midIndex];
        if (midIndexValue == searchValue) return midIndex;
        if (searchValue < midIndexValue)
            return binarySearch(numbers, startIndex, midIndex - 1, searchValue);
        else
            return binarySearch(numbers, midIndex + 1, endIndex, searchValue);
    }
}
