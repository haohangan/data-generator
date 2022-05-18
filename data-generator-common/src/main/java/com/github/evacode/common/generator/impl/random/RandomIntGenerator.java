package com.github.evacode.common.generator.impl.random;

import com.github.evacode.common.generator.IntGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class RandomIntGenerator extends IntGenerator {

    protected final int min;

    protected final int max;

    public RandomIntGenerator(int min, int max) {
        this.checkNum(min);
        this.checkNum(max);
        this.min = min;
        this.max = max;
    }


    public RandomIntGenerator() {
        this.min = 0;
        this.max = Integer.MAX_VALUE;
    }

    @Override
    public int[] generate(int num) {
        this.checkNum(num);
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        int[] result = new int[num];
        for (int i = 0; i < num; i++) {
            result[i] = tlr.nextInt(this.min, this.max);
        }
        return result;
    }
}
