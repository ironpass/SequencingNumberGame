package com.ood.sequencingnumber;

import java.util.ArrayList;

/**
 * Created by ood on 31-May-17.
 */

public class Stat {
    private ArrayList<Long> history;
    public Stat() {
        history = new ArrayList<Long>();
    }
    public void addResult(long result) {
        history.add(result);
    }
    public long getAverage() {
        long average = 0;
        for (int i = 0;i<history.size();i++) {
            average+=history.get(i);
        }
        return average/history.size();
    }
}
