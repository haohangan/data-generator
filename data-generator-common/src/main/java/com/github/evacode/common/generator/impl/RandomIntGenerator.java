package com.github.evacode.common.generator.impl;

import com.github.evacode.common.generator.IntGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class RandomIntGenerator extends IntGenerator {

    protected final int min;

    protected final int max;

    public RandomIntGenerator(int min, int max) {
        this.min = min;
        this.max = max;
    }


    public RandomIntGenerator() {
        this.min = 0;
        this.max = Integer.MAX_VALUE - 1;
    }

    @Override
    public int[] generate(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("num 不能为负数");
        }
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        int[] result = new int[num];
        for (int i = 0; i < num; i++) {
            result[i] = tlr.nextInt(this.min, this.max + 1);
        }
        return result;
    }
}
