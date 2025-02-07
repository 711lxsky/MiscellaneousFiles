package practice;

public class T121_240815 {

    class Solution {
        public int maxProfit(int[] prices) {
            int maxBenefit = 0;
            int minPrice = prices[0];
            for(int price : prices){
                maxBenefit = Math.max(maxBenefit, price - minPrice);
                minPrice = Math.min(minPrice, price);
            }
            return maxBenefit;
        }
    }

}
