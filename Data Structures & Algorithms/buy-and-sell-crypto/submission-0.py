class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        i,j = 0,0
        profit = 0
        maxProfit = 0

        while j < len(prices):


            if prices[j] > prices[i]:
                profit = prices[j] - prices[i]
                maxProfit = max(maxProfit,profit)
            else:#if prices[i] > prices[j]
                while prices[i] > prices[j]:
                    i += 1
            j+=1
        return maxProfit
            


