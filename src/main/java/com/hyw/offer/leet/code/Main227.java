package com.hyw.offer.leet.code;

import java.util.Arrays;
import java.util.Stack;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/28 15:11
 * Description：TODO
 */
public class Main227 {

    public static void main(String[] args) {
        Main227 main227 = new Main227();
        System.out.println(main227.calculate("3+2*2"));
    }

    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();
        Character lastOp = '+';
        char[] chars = s.toCharArray();
        int n = chars.length;


        for (int i = 0; i < n; i++) {
            if (chars[i] == ' ') {
                continue;
            }
            if (Character.isDigit(chars[i])) {
                int num = chars[i] - '0';
                while (++i < n && Character.isDigit(chars[i])) {
                    num = num * 10 + (chars[i] - '0');
                }
                i--;
                if (lastOp == '+') {
                    stack.push(num);
                } else if (lastOp == '-') {
                    stack.push(-num);
                } else {
                    stack.push(computeOp(lastOp, stack.pop(), num));
                }
            } else {
                lastOp = chars[i];
            }

        }

        return stack.stream().mapToInt(num -> num).sum();

    }

    private Integer computeOp(Character optChar, Integer first, int second) {
        OptionEnum option = OptionEnum.of(optChar);
        return option.compute(first, second);
    }

    public enum OptionEnum {

        /**
         *
         */
        ADD('+') {
            @Override
            int compute(int a, int b) {
                return a + b;
            }
        },
        SUBSTRCT('-') {
            @Override
            int compute(int a, int b) {
                return a - b;
            }
        },
        MULTIPLY('*') {
            @Override
            int compute(int a, int b) {
                return a * b;
            }
        },
        DIVID('/') {
            @Override
            int compute(int a, int b) {
                return a / b;
            }
        };
        private final char opion;

        OptionEnum(char opion) {
            this.opion = opion;
        }

        public static OptionEnum of(char param) {
            return Arrays.stream(values())
                    .filter(bean -> bean.opion == param)
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException("非法参数异常"));
        }

        abstract int compute(int a, int b);
    }

}
