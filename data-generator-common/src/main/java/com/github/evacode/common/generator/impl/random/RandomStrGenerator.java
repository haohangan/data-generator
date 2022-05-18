package com.github.evacode.common.generator.impl.random;

import com.github.evacode.common.generator.StrGenerator;

import java.util.concurrent.ThreadLocalRandom;

/**
 * <a href="https://www.qqxiuzi.cn/zh/hanzi-unicode-bianma.php">参考</a>
 */
public class RandomStrGenerator extends StrGenerator {


    /**
     * 生成字符串的长度默认最大值
     */
    private static final int DEFAULT_LENGTH = 10;
    private static final char UNICODE_MIN = 0x0000;
    private static final char UNICODE_MAX = 0xffff;
    private final int min;
    private final int max;


    private final char uMin;
    private final char uMax;

    public RandomStrGenerator() {
        this.min = 0;
        this.max = DEFAULT_LENGTH;
        this.uMin = UNICODE_MIN;
        this.uMax = UNICODE_MAX;
    }

    public RandomStrGenerator(int length, char uMin, char uMax) {
        this.min = length;
        this.max = length;
        this.uMin = uMin;
        this.uMax = uMax;
    }


    public RandomStrGenerator(int min, int max, char uMin, char uMax) {
        this.min = min;
        this.max = max;
        this.uMin = uMin;
        this.uMax = uMax;
    }

    @Override
    public String[] generate(int num) {
        this.checkNum(num);
        String[] result = new String[num];
        boolean fixedLength = this.min == this.max;
        for (int i = 0; i < num; i++) {
            int length = fixedLength ? this.min : ThreadLocalRandom.current().nextInt(this.min, this.max);
            char[] value = new char[length];
            for (int j = 0; j < length; ) {
                int r = ThreadLocalRandom.current().nextInt(this.uMin, this.uMax);
                char[] nv = Character.toChars(r);
                for (char c : nv) {
                    value[j] = c;
                    j++;
                    if (j >= length) {
                        break;
                    }
                }
            }
            result[i] = new String(value);
        }
        return result;
    }
}
