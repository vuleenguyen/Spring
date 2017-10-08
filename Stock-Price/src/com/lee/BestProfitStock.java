package com.lee;

/**
 * Created by Do My Duyen on 8/31/2017.
 */
public class BestProfitStock {

    public int getMaxProfit(int[] stockPricesYesterday) {

        if (stockPricesYesterday.length < 2) {
            throw new IllegalArgumentException("stock Price Yesterday must greater than 2 element");
        }

        int maxProfit = stockPricesYesterday[1] - stockPricesYesterday[0];
        int minStock = Math.min(stockPricesYesterday[0], stockPricesYesterday[1]);
        for(int i = 2; i < stockPricesYesterday.length; i++) {

            int currentProfix = stockPricesYesterday[i] - minStock;

            maxProfit = Math.max(currentProfix, maxProfit);

            minStock = Math.min(minStock, stockPricesYesterday[i]);
        }
        return maxProfit;
    }
}
