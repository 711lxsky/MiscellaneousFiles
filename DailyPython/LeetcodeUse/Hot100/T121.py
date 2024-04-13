from ast import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        min_price = prices[0]
        max_profit = 0
        n = len(prices)
        for i in range(1, n) :
            if prices[i] < min_price :
                min_price = prices[i]
            else :
                max_profit = max(max_profit, prices[i] - min_price)
        return max_profit