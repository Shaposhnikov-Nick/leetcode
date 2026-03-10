public class Solution_1422_MaximumScoreAfterSplittingString {
    public static void main(String[] args) {
        var s = "011101";
        maxScore(s);
    }

    private static int maxScore(String s) {
        var n = s.length();
        var arr = s.toCharArray();
        var onePrefixSum = new int[n];
        var zeroPrefixSum = new int[n];
        var maxSum = 0;


        if (arr[0] - '0' == 1)
            onePrefixSum[0] = 1;
        else
            zeroPrefixSum[0] = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] - '0' == 1) {
                onePrefixSum[i] = onePrefixSum[i - 1] + 1;
                zeroPrefixSum[i] = zeroPrefixSum[i - 1];
            } else {
                onePrefixSum[i] = onePrefixSum[i - 1];
                zeroPrefixSum[i] = zeroPrefixSum[i - 1] + 1;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            var zeroCount = zeroPrefixSum[i];
            var oneCount = onePrefixSum[n - 1] - onePrefixSum[i];
            var sum = zeroCount + oneCount;
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
