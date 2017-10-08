package com.lee;

import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<Integer, Long> memo = new HashMap<>();

    public static void main(String[] args) {
	// write your code here
        long result = findFibonaccy(4);
        System.out.println(result);
    }

    public static long findFibonaccy(int n) {

        if (memo.containsKey(n)) {
            System.out.println(String.format("Grabbing memo [%s]", n));
            return memo.get(n);
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        System.out.println(String.format("Calculate Fibonacy of [%d]", n));

        long result = findFibonaccy(n -1) + findFibonaccy(n-2);

        memo.put(n, result);
        return result;
    }
}
