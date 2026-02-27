import java.util.HashSet;

public class Solution_771_JewelsAndStones {
    public static void main(String[] args) {
        var jewels = "aA";
        var stones = "aAAbbbb";
        numJewelsInStones(jewels, stones);
    }

    private static int numJewelsInStones(String jewels, String stones) {
        var jewelsCounter = 0;
        var set = new HashSet<Character>();

        for (var ch : jewels.toCharArray()) {
            set.add(ch);
        }

        for (var stone : stones.toCharArray()) {
            if (set.contains(stone)) jewelsCounter++;
        }

        return jewelsCounter;
    }
}
