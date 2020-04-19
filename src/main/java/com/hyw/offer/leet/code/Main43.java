package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/30 15:02
 * Description：TODO
 */
public class Main43 {

    public static void main(String[] args) {
        Main43 main43 = new Main43();
        System.out.println(main43.multiply("123", "0"));
    }

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int sum = a * b + res[i + j + 1];
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (res[0] != 0) {
            sb.append(res[0]);
        }
        for (int i = 1; i < res.length; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }

}
