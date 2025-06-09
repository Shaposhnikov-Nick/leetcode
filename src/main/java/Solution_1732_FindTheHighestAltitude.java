public class Solution_1732_FindTheHighestAltitude {
    public static void main(String[] args) {
        var gain = new int[]{-5, 1, 5, 0, -7};
        System.out.println(largestAltitude(gain));
    }

    private static int largestAltitude(int[] gain) {
        var largest = 0;
        var current = 0;

        for (int alt : gain) {
            current += alt;
            largest = Math.max(largest, current);
        }

        return largest;
    }
}
