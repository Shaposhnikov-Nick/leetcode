public class Solution_1475_FinalPricesWithSpecialDiscountInShop {
    public static void main(String[] args) {
        var prices = new int[]{8, 4, 6, 2, 3};
        finalPrices(prices);
    }

    private static int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length - 2; i++) {
            for (int j = i + 1; j < prices.length - 1; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }

        return prices;
    }
}
