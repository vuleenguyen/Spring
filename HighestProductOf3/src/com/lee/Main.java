package com.lee;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int highestProduct = highestProductOfThree(new int[]{1, 10, -5, 1, -100});
        System.out.println(highestProduct);
    }

    public static int highestProductOfThree(int[] arr) {
        if (arr.length < 3) {
            throw new IllegalArgumentException("Product must greater than 3");
        }

        int highestProductOf3 = arr[0] * arr[1] * arr[2];
        int highestProductOf2 = arr[0] * arr[1];
        int lowestProductOf2 = arr[0] * arr[1];
        int highest = Math.max(arr[0], arr[1]);
        int lowest = Math.min(arr[0], arr[1]);

        for(int i = 2 ; i < arr.length ; i++) {
            int current = arr[i];

            highestProductOf3 = Math.max(highestProductOf2 * current, lowestProductOf2 * current);

            highestProductOf2 = Math.max(Math.max(highest*current, lowest* current), highestProductOf2);
            lowestProductOf2 = Math.min(Math.min(highestProductOf2 * current, lowest* current), lowestProductOf2);

            highest = Math.max(highest, current);
            lowest = Math.min(lowest, current);
        }
        return highestProductOf3;
    }

//    public static int highestProductOfThree(int[] arr) {
//        if (arr.length < 3) {
//            throw new IllegalArgumentException("product integer fewer than 3");
//        }
//
//        int highestProductOfThree = arr[0] * arr[1] * arr[2];
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//        int minIndex = 0;
//        int maxIndex = arr.length - 1;
//        for(int i = 0; i < arr.length ; i++) {
//            if (arr[i] < min) {
//                min = arr[i];
//                minIndex = i;
//            }
//
//            if (arr[i] > max) {
//                max = arr[i];
//                maxIndex = i;
//            }
//        }
//
//        int secondMax = Integer.MIN_VALUE;
//        int secondMaxIndex = arr.length - 2;
//        for(int i = 0 ; i < arr.length; i++) {
//            if (arr[i] > secondMax && arr[i] < max) {
//                secondMax = arr[i];
//                secondMaxIndex = i;
//            }
//        }
//
//        for(int i = 0; i < arr.length ; i++) {
//            if (i == minIndex || i == maxIndex || i == secondMaxIndex) continue;
//            if (min * max * arr[i] > max * secondMax * arr[i]) {
//                if (min * max * arr[i] > highestProductOfThree) {
//                    highestProductOfThree = min * max * arr[i];
//                }
//            } else {
//                if (max * secondMax * arr[i] > highestProductOfThree) {
//                    highestProductOfThree = max * secondMax * arr[i];
//                }
//            }
//        }
//
//        return highestProductOfThree;
//    }


//    public static int highestProductOfThree(int[] arr) {
//        if (arr.length < 3) {
//            throw new IllegalArgumentException("products fewer than 3 integer");
//        }
//
//        int highestProduct = Integer.MIN_VALUE;
//        int highestProductIndex = 0;
//        for(int i = 0 ; i < arr.length ; i++) {
//            if (arr[i] > highestProduct) {
//                highestProduct = arr[i];
//                highestProductIndex = i;
//            }
//        }
//
//        int lowestProductOf2 = Integer.MAX_VALUE;
//        int highestProductOf2 = Integer.MIN_VALUE;
//        int lowestProductIndex = 0;
//        int secondhighestProductIndex = 0;
//         for(int i = 0; i < arr.length; i++) {
//            if (i == highestProductIndex) continue;
//            if (highestProductOf2 > highestProduct * arr[i]) {
//                highestProductOf2 = highestProduct * arr[i];
//                lowestProductIndex = i;
//            }
//
//            if (lowestProductOf2 > highestProduct * arr[i]) {
//                lowestProductOf2 = highestProduct * arr[i];
//                secondhighestProductIndex = i;
//            }
//        }
//
//        int highestProductOf3 = arr[0] * arr[1] * arr[2];
//
//        for(int i = 0; i < arr.length ; i++) {
//            if (i == highestProductIndex || i == lowestProductIndex || i == secondhighestProductIndex) continue;
//            highestProductOf3 = Math.max(highestProductOf3, Math.max(highestProductOf2 * arr[i], lowestProductOf2 * arr[i]));
//        }
//
//        return highestProductOf3;
//    }
}
