package com.hyw.effective;

import java.util.function.DoubleBinaryOperator;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/6 9:33
 * Description：TODO
 */
public enum Operation {
    /**
     * 加
     */
    PLUS("+", Double::sum);

    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }

}
