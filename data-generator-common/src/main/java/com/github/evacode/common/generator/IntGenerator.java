package com.github.evacode.common.generator;

import com.github.evacode.common.type.GeneratorTypeEnum;

public abstract class IntGenerator {

    protected final int max;

    public IntGenerator(int max) {
        this.max = max;
    }

    /**
     * 生成int数组
     *
     * @param num 生产的数据数目
     * @return int数组
     */
    public abstract int[] generate(int num);


    public final GeneratorTypeEnum getType() {
        return GeneratorTypeEnum.INT;
    }
}
