package com.lee;

public class Main {

    public static void main(String[] args) {
        int[] result = getProductsOfAllIntsExceptAtIndex(new int[]{1,2,6,5,9});
        for(int i = 0 ; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] getProductsOfAllIntsExceptAtIndex(int[] products) {

        if (products.length < 2) throw new IllegalArgumentException("products has fewer than two integers");

        int[] productsOfAllIntsExceptAtIndex = new int[products.length];
        int productCurrent = 1;
        for(int i = 0 ; i < products.length; i++) {
            productsOfAllIntsExceptAtIndex[i] = productCurrent;
            productCurrent *= products[i];
        }

        productCurrent = 1;
        for(int j = products.length - 1; j >= 0 ; j--) {
            productsOfAllIntsExceptAtIndex[j] *= productCurrent;
            productCurrent *= products[j];
        }

        return productsOfAllIntsExceptAtIndex;
    }

//    public static int[] getProductsOfAllIntsExceptAtIndex(int[] products) {
//        int[] productsOfAllIntsExceptAtIndex = new int[products.length];
//        for(int i = 0; i < products.length; i++) {
//            productsOfAllIntsExceptAtIndex[i] = 1;
//            for( int j = 0 ; j < products.length ; j++) {
//                if (i == j) continue;
//                productsOfAllIntsExceptAtIndex[i] = productsOfAllIntsExceptAtIndex[i] * products[j];
//            }
//        }
//        return  productsOfAllIntsExceptAtIndex;
//    }
}
