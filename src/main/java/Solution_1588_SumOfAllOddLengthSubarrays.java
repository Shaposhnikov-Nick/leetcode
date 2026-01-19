public class Solution_1588_SumOfAllOddLengthSubarrays {
    public static void main(String[] args) {
        var arr = new int[]{1, 4, 2, 5, 3};
        sumOddLengthSubarrays(arr);
    }

    private static int sumOddLengthSubarrays(int[] arr) {
        var n = arr.length;
        var prefixSum = new int[n + 1];
        var totalSum = 0;

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                var length = end - start + 1;
                if (length % 2 == 1) {
                    totalSum += prefixSum[end + 1] - prefixSum[start];
                }

            }
        }

        return totalSum;
    }
}
