package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/5 15:17
 * Description：TODO
 */
public class Main33 {

    public static void main(String[] args) {
        Main33 main = new Main33();
        int[] sequence = {7, 4, 6, 5};
        System.out.println(main.verifySquenceOfBST(sequence));
    }

    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int first, int last) {

        if (first >= last) {
            return true;
        }

        int rootVal = sequence[last];
        int cutVal = first;
        while (cutVal < last && sequence[cutVal] < rootVal) {
            cutVal++;
        }
        for (int i = cutVal; i < last; i++) {
            if (sequence[i] < rootVal) {
                return false;
            }
        }

        return verify(sequence, first, cutVal - 1) && verify(sequence, cutVal, last - 1);
    }

}
