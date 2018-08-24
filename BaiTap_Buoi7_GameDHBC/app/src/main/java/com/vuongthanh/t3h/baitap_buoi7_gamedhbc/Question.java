package com.vuongthanh.t3h.baitap_buoi7_gamedhbc;

import java.util.ArrayList;
import java.util.Random;

public class Question {
    private int resourceImage;
    private String result;
    private char[] pick = new char[16];
    private int charNumber;

    public Question(int resourceImage, String result) {
        this.resourceImage = resourceImage;
        this.result = result;
        randomPick();
        this.charNumber = result.length();
    }

    public int getCharNumber() {
        return charNumber;
    }

    public void setCharNumber(int charNumber) {
        this.charNumber = charNumber;
    }

    public Question() {
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public String getResult() {
        return result;
    }

    public void setResult_charNumber(String result) {
        this.result = result;
        this.charNumber = result.length();
    }

    public char[] getPick() {
        return pick;
    }

    public void setPick(char[] pick) {
        this.pick = pick;
    }

    public void randomPick() {
        String temp = result;
        Random random = new Random();
        for (int i = 0; i < 16 - result.length(); i++) {
            int a = 97 + random.nextInt(26);
            char k = (char) a;
            temp += k;
        }

        ArrayList<Integer> arrIndex = new ArrayList<>();
        char[] pickTemp = temp.toCharArray();
        int index = 0;

        for (int i = 0; i < 16; i++) {
            index = random.nextInt(16);
            while (checkIndex(arrIndex, index)) {
                index = random.nextInt(16);
            }
            arrIndex.add(index);
            pick[i] = pickTemp[index];
        }
    }

    private boolean checkIndex(ArrayList<Integer> arrIndex, int k) {
        if (arrIndex.size() == 0) return false;
        else {
            for (int i = 0; i < arrIndex.size(); i++) {
                if (arrIndex.get(i) == k)
                    return true;
            }
        }
        return false;
    }
}
