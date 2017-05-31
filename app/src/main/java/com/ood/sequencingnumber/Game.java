package com.ood.sequencingnumber;

/**
 * Created by ood on 31-May-17.
 */

public class Game {
    private int[] layer1;
    private int[] layer2;
    private int idx;
    private int currentNumber;
    long startTime;
    public Game() {
        startTime = System.currentTimeMillis();
        layer1 = new int[20];
        layer2 = new int[20];
        for (int i = 1;i<=20;i++) {
            layer1[i-1] = i;
            layer2[i-1] = i+20;
        }
        shuffle(layer1);
        shuffle(layer2);
        idx = 0;
        currentNumber = 0;
    }
    private void shuffle(int[] array) {
        int temp, currentIdx, length = array.length;
        while (--length > 0) {
            currentIdx = (int) Math.floor(Math.random() * (length+1));
            temp = array[currentIdx];
            array[currentIdx] = array[length];
            array[length] = temp;
        }
    }
    public int[] getLayer1() {
        return this.layer1;
    }
    public int[] getLayer2() {
        return this.layer2;
    }

    public int getNextNumber() {
        return layer2[idx++];
    }

    public boolean isNextNumber(int number) {
        if(number==currentNumber+1) {
            currentNumber = number;
            return true;
        }
        return false;
    }

    public long getEndTime() {
        return System.currentTimeMillis()-startTime;
    }
}
