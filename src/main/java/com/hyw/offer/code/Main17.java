package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/1/17 11:25
 * Description：TODO
 */
public class Main17 {

    public static void main(String[] args) {

        print1ToMaxOfNDigits(3);
    }

    public static void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] chars = new char[n];


        print1ToMaxOfNDigits(chars, 0);
    }

    public static void print1ToMaxOfNDigits(char[] number, int digit) {

        if (digit == number.length) {
            printNumber(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[digit] = (char)(i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }

    }

    /**
     * 负责答应
     * @param number： char数组
     */
    public static void printNumber(char[] number) {
        int index = 0;
        while (number.length > index && number[index] == 0) {
            index++;
        }
        while (index < number.length) {
            System.out.print(number[index++]);
        }
        System.out.println();
    }

}
