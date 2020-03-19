package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/12 16:37
 * Description：TODO
 */
public class Main69 {

    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int l = 2;
        int r = x / 2;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int left = mid * mid;
            int right = (mid + 1)*(mid + 1);
            if (left == x) {
                return mid;
            }
            if (right == x) {
                return mid + 1;
            }
            if (left < x && right > x) {
                return mid;
            } else if(right < x) {
                l = mid + 1;
            } else {
                r = mid -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Main69 main69 = new Main69();
        System.out.println(main69.mySqrt(36));
    }

}
