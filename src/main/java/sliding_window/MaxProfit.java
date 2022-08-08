package sliding_window;

public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        MaxProfit maxProfit = new MaxProfit();

        int maxProfitVal = maxProfit.findMaxProfit(prices);
        System.out.println(maxProfitVal);

        int[] maxProfAndIndices = maxProfit.findMaxProfitAndIndices(prices);
        System.out.println("Buy on day " + maxProfAndIndices[0] + " at price £" + prices[maxProfAndIndices[0]] + " and sell on day " + maxProfAndIndices[1] + " at price £" + prices[maxProfAndIndices[1]] + " to make a maximum profit of " + maxProfAndIndices[2]);

    }

    // This method uses a sliding window to find the max profit that was possible looking over previous prices
    // Main thing to note:
    // left pointer is always the min value
    // right is always updating but if it is smaller than current left then update the left to the right val
    // also store the max profit
    // This technique reduces the brute force method of o(n^2) method down to o(n)!!!
    public int findMaxProfit(int[] prices){
        int lowestVal = prices[0];
        int rightPointerVal = prices[0];

        // var to hold maxProfit
        int maxProfit = 0;

        // Loop through the array with rightPointer increasing each time
        for (int i = 1; i < prices.length; i++){
            rightPointerVal = prices[i];

            if (rightPointerVal < lowestVal){
                lowestVal = rightPointerVal;
            } else {
                int profit = rightPointerVal - lowestVal;
                if (profit > maxProfit) maxProfit = profit;
            }
        }
        return maxProfit;
    }

    // This one uses actual pointers and is able to return the indices
    public int[] findMaxProfitAndIndices(int[] prices){
        // use left and right pointers to keep track of indices
        int l = 0;


        // var to hold maxProfit
        int maxProfit = 0;
        int maxValIndex = 0;

        // Loop through the array with rightPointer increasing each time
        // right pointer is initialised here
        for (int r = 1; r < prices.length; r++){

            if (prices[r] < prices[l]){
                // if left pointer price is lower than right
                // Update pointer to index with min value!!
                l = r;
            } else {
                int profit = prices[r] - prices[l];
                if (profit > maxProfit) {
                    maxProfit = profit;
                    maxValIndex = r;
                }
            }
        }
        return new int[] { l, maxValIndex, maxProfit};
    }
}
