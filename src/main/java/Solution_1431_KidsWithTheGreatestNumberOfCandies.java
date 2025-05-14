import java.util.Arrays;
import java.util.List;

public class Solution_1431_KidsWithTheGreatestNumberOfCandies {
    public static void main(String[] args) {
        var candies = new int[]{2, 3, 5, 1, 3};
        var extraCandies = 3;
        System.out.println(kidsWithCandies(candies, extraCandies));
    }

    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        var maxCandies = Arrays.stream(candies).max().getAsInt();
        return Arrays.stream(candies).mapToObj(candy -> candy + extraCandies >= maxCandies).toList();
    }
}
