package com.lee;

import java.util.List;

/**
 * Created by Do My Duyen on 9/9/2017.
 */
public class Main {

    public static void main(String[] args) {
        TempTracker tempTracker = new TempTracker();
        tempTracker.insert(1);
        tempTracker.insert(3);
        tempTracker.insert(6);
        tempTracker.insert(3);
        tempTracker.insert(1);
        tempTracker.insert(3);
        tempTracker.insert(7);
        tempTracker.insert(2);
        tempTracker.insert(2);
        tempTracker.insert(3);

        Integer result = tempTracker.getMode();
        System.out.println("Mode is: " + result);
        System.out.println("Max is: " + tempTracker.getMax());
        System.out.println("Min is: " + tempTracker.getMin());
        System.out.printf("%.2f" , tempTracker.getMean());
    }
}
