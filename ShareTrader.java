public class ShareTrader {
    static int maxProfit;

    public static int findMaxProfit(int[] stockPrices) {
        int n = stockPrices.length;
        int profit = 0;
        int buyPrice = stockPrices[0];

        for (int i = 1; i < n; i++) {
            if (stockPrices[i] < stockPrices[i - 1]) {
                profit += stockPrices[i - 1] - buyPrice;
                buyPrice = stockPrices[i];
            }
        }

        // Update profit for the last transaction
        profit += stockPrices[n - 1] - buyPrice;
        return profit;
    }

    public static void main(String[] args) {
        int[] prices1 = {10, 22, 5, 75, 65, 80};
        int[] prices2 = {2, 30, 15, 10, 8, 25, 80};

        System.out.println("Prices 1: " + findMaxProfit(prices1));
        System.out.println("Prices 2: " + findMaxProfit(prices2));
    }
}

