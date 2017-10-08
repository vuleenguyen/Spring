package com.lee;

public class Main {

    public static void main(String[] args) {
        int numberOfWay = numberOfWayToMakeAmountWithDenominations(5, new int[]{1,2,5});
        System.out.println(numberOfWay);
    }

    public static int numberOfWayToMakeAmountWithDenominations(int amount, int[] denominations) {
        int[] wayOfDoingCent = new int[amount+1];
        wayOfDoingCent[0] = 1;

        for(int coin: denominations) {
            for(int i = coin; i < wayOfDoingCent.length; i++) {
                 wayOfDoingCent[i] += wayOfDoingCent[i - coin];
            }
        }
        return wayOfDoingCent[amount];
    }
}
