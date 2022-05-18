package com.github.evacode.common.generator;

import com.github.evacode.common.type.GeneratorTypeEnum;

public abstract class StrGenerator extends AbsGenerator {

    /**
     * 生成int数组
     *
     * @param num 生产的数据数目
     * @return int数组
     */
    public abstract String[] generate(int num);

    @Override
    public final GeneratorTypeEnum getType() {
        return GeneratorTypeEnum.STR;
    }
}
