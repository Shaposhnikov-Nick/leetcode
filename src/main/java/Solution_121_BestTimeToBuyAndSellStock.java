public class Solution_121_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        var prices = new int[]{7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        var profit = 0;
        var iBuy = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[iBuy]) iBuy = i;
            profit = Math.max(profit, prices[i] - prices[iBuy]);
        }

        return profit;
    }
}
