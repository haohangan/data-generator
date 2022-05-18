package com.github.evacode.common.generator;

import com.github.evacode.common.type.GeneratorTypeEnum;

public abstract class AbsGenerator {


    public abstract GeneratorTypeEnum getType();


    /**
     * 检查数字不能小于0
     */
    protected void checkNum(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("num 不能为负数");
        }
        if (num >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("num 不能为大于等于Integer.MAX_VALUE");
        }
    }


    /**
     * 是偶数
     */
    public boolean isOdd(int num) {
        return (num & 1) != 1;
    }
}
