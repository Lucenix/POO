package com.poo.ficha2;

import java.util.Arrays;

public class Ficha2_5 {
    String[] stringArray;

    public Ficha2_5(String[] stringArray) {
        this.stringArray = stringArray;
    }

    public String[] stringDistinct() {
        return (String[]) Arrays.stream(this.stringArray).distinct().toArray();
    }

    public String maxString() {
        int maxind = 0, maxLen = this.stringArray[maxind].length();
        for(int i = 1; i< stringArray.length; i++) {
            int currLen = this.stringArray[i].length();
            if (maxLen < currLen) {
                maxind = i;
                maxLen = currLen;
            }

        }
        return this.stringArray[maxind];
    }

}
