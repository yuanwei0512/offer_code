package com.hyw.effective;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/2 9:40
 * Description：TODO
 */
public class NutrtionFacts {

    private final int servingSize;
    private final int serving;
    private final int calories;
    private final int fat;

    public static class Builder {
        private int servingSize;
        private int serving;
        private int calories = 0;
        private int fat = 0;

        public Builder builderCalores(int n) {
            this.calories = n;
            return this;
        }
        public Builder builderFat(int n) {
            this.fat = n;
            return this;
        }

        public NutrtionFacts build() {
            if (calories > fat) {
                throw new IllegalArgumentException("非法参数异常");
            }
            return new NutrtionFacts(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private NutrtionFacts(Builder builder) {
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.serving = builder.serving;
        this.servingSize = builder.servingSize;

    }

    public static void main(String[] args) {
        NutrtionFacts build = NutrtionFacts.builder()
                .builderCalores(5)
                .builderFat(3)
                .build();
    }
}
