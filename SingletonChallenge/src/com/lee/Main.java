package com.lee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Do My Duyen on 9/15/2017.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> lists = new ArrayList<>();
        lists.add(1);
        lists.add(2);
        lists.add(3);

        for(int i = 0; i < lists.size(); i++) {
            lists.remove(1);
        }
    }
}
