package com.lee;

public class Main {

    public static void main(String[] args) {
        int[] stockPricesYesterday = new int[] {10,7,5,8,11,9};
        BestProfitStock bestProfitStock = new BestProfitStock();
        System.out.println(bestProfitStock.getMaxProfit(stockPricesYesterday));
    }
}
