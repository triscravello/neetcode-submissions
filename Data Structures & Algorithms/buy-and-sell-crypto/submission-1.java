class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // update minimum price seen on the ith day
            minPrice = Math.min(minPrice, price);

            // calculate profit if sold today
            int profit = price - minPrice;

            // update maximum profit seen so far
            maxProfit = Math.max(maxProfit, profit);
        }

        // return maximum profit to achieve from transaction
        return maxProfit;
    }
}
