public class Solution_11_ContainerWithMostWater {
    public static void main(String[] args) {
        var height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        var left = 0;
        var right = height.length - 1;
        var maxArea = 0;

        while (left < right) {
            var lValue = height[left];
            var rValue = height[right];
            var minValue = Math.min(lValue, rValue);
            var currentArea = minValue * (right - left);
            maxArea = Math.max(maxArea, currentArea);
            if (lValue < rValue) left++;
            else right--;
        }

        return maxArea;
    }
}
