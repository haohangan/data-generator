package com.github.evacode.common.generator.impl;

import com.github.evacode.common.generator.IntGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class RandomIntGenerator extends IntGenerator {

    public RandomIntGenerator(int max) {
        super(max);
    }

    public RandomIntGenerator() {
        super(Integer.MAX_VALUE);
    }

    @Override
    public int[] generate(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("num 不能为负数");
        }
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        int[] result = new int[num];
        for (int i = 0; i < num; i++) {
            result[i] = tlr.nextInt(this.max);
        }
        return result;
    }
}
