class Solution {
    /**
     * @param {number[]} prices
     * @return {number}
     */
    maxProfit(prices) {
        let minPrice = Infinity;
        let maxProfit = 0;

        for (let i = 0; i < prices.length; i++) {
            // update minimum price seen on the ith day
            if (prices[i] < minPrice) {
                minPrice = prices[i]
            }

            // calculate profit if sold today
            else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        // return maximum profit to achieve from transaction
        return maxProfit;
    }
}
