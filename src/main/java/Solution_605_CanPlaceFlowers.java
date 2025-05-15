public class Solution_605_CanPlaceFlowers {
    public static void main(String[] args) {
        var flowerbed = new int[]{0, 1, 0, 1, 0, 1, 0, 0};
        var n = 2;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    private static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            var left = i > 0 ? flowerbed[i - 1] : 0;
            var right = i < flowerbed.length - 1 ? flowerbed[i + 1] : 0;
            if (left + flowerbed[i] + right == 0) {
                flowerbed[i] = 1;
                if (--n == 0) return true;
            }
        }
        return n <= 0;
    }
}
