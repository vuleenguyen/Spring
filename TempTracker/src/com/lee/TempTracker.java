package com.lee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TempTracker {

    // max and min
    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE;
    // mean
    private double totalTemperature = 0.0;
    private int numberTemperature = 0;
    private double mean;
    // mode
    private int[] timesTemperature = new int[111];
    private int maxOfTimes = Integer.MIN_VALUE;
    private int mode;

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public double getMean() {
        return mean;
    }

    public int getMode() {
        return mode;
    }

    public void insert(int newTemperature) {
        max = Math.max(newTemperature, max);
        min = Math.min(newTemperature, min);

        totalTemperature += newTemperature;
        numberTemperature++;

        mean = totalTemperature / numberTemperature;

        timesTemperature[newTemperature]++;
        if (maxOfTimes < timesTemperature[newTemperature]) {
            maxOfTimes = timesTemperature[newTemperature];
            mode = newTemperature;
        }
    }
}
