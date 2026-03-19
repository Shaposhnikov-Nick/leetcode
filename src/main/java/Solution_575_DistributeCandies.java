import java.util.HashSet;

public class Solution_575_DistributeCandies {
    public static void main(String[] args) {
        var candyType = new int[]{1, 1, 2, 2, 3, 3};
        distributeCandies(candyType);
    }

    private static int distributeCandies(int[] candyType) {
        var maxCandies = candyType.length / 2;
        var set = new HashSet<Integer>();

        for (var candy: candyType){
            set.add(candy);
            if (set.size() == maxCandies) return maxCandies;
        }

        return set.size();
    }
}
