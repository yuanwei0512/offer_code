package com.hyw.offer.leet.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/24 16:22
 * Description：TODO
 */
public class Main166 {


    public static void main(String[] args) {
        Main166 main166 = new Main166();
        System.out.println(main166.fractionToDecimal(1, 3));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "";
        }
        if (denominator == 0) {
            throw new IllegalArgumentException("0 can not be a divisor");
        }
        StringBuilder sb = new StringBuilder();
        if (numerator > 0 ^ denominator > 0) {
            sb.append("-");
        }
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        sb.append(dividend / divisor);
        long remain = dividend % divisor;
        if (remain == 0) {
            return sb.toString();
        }
        sb.append(".");


        Map<Long, Integer> map = new HashMap<>();
        while (remain > 0) {
            if (map.containsKey(remain)) {
                sb.insert(map.get(remain), "(");
                sb.append(")");
                break;
            }
            map.put(remain, sb.length());
            remain *= 10;
            sb.append(remain / divisor);
            remain = remain % divisor;
        }
        return sb.toString();

    }

}
