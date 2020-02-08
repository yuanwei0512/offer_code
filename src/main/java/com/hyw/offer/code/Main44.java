package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/8 15:02
 * Description：TODO
 */
public class Main44 {

    public static void main(String[] args) {
        Main44 main44 = new Main44();
        System.out.println(main44.getDigitAtIndex(1001));
    }

    public int getDigitAtIndex(int index) {
        if (index == 0) {
            return -1;
        }
        index -= 1;
        int n = 1;
        int multiIndex = 9;
        while ((index - n * multiIndex) >= 0) {
            index -= n * multiIndex;
            n++;
            multiIndex *= 10;
        }
        int temp = 1 ;
        for (int i = 1; i < n; i++) {
            temp *= 10;
        }
        temp += index / n;
        int resultIndex = index % n;
        return getIndexForValue(temp, resultIndex, n);
    }

    private int getIndexForValue(int value, int index, int n) {
        index = n - index - 1;
        for (int i = 0; i < index; i++) {
            value = value / 10;
        }
        return value % 10;
    }


}
