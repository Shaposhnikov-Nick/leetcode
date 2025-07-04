import java.util.ArrayDeque;

public class Solution_649_Dota2Senate {
    public static void main(String[] args) {
        var senate = "RDD";
        System.out.println(predictPartyVictory(senate));
    }

    private static String predictPartyVictory(String senate) {
        var radiantQueue = new ArrayDeque<Integer>();
        var direQueue = new ArrayDeque<Integer>();
        var n = senate.length();
        var senateArr = senate.toCharArray();

        for (int i = 0; i < n; i++) {
            if (senateArr[i] == 'R') radiantQueue.addLast(i);
            else direQueue.addLast(i);
        }

        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            var rIndex = radiantQueue.poll();
            var dIndex = direQueue.removeFirst();

            if ((rIndex < dIndex)) radiantQueue.addLast(rIndex + n);
            else direQueue.addLast(dIndex + n);
        }

        return !radiantQueue.isEmpty() ? "Radiant" : "Dire";
    }
}
