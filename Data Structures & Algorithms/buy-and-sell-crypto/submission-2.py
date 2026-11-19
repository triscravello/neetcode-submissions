class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        min_price = float('inf')
        max_profit = 0

        for price in prices:
            # update minimum price seen on the ith day
            min_price = min(min_price, price)
            
            # calculate profit if sold today
            profit = price - min_price
            
            # update maximum profit seen so far
            max_profit = max(max_profit, profit)

        # return maximum profit to achieve from transaction
        return max_profit