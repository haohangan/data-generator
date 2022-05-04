package com.github.evacode.common;

import com.github.curiousoddman.rgxgen.RgxGen;

/**
 * generate data by regex
 */
public class RegexGenUtil {

    /**
     * 手机号码pattern
     */
    public static final String PHONE_REGEX = "^1[3456789]\\d{9}$";

    /**
     * 中文pattern
     */
    public static final String CN_REGEX_TEMPLATE = "^([\u4e00-\u9fa5]){min,max}$";

    /**
     * 生成中文字符串
     *
     * @param min    字符串长度最小值
     * @param max    字符串长度最大值
     * @param number 字符串个数
     * @return 生成的中文字符串数组
     */
    public static String[] generateChinese(String min, String max, int number) {
        String re = CN_REGEX_TEMPLATE.replace("min", min).replace("max", max);
        return generate(re, number);
    }

    /**
     * 生成单个中文字符串
     *
     * @param min 字符串长度最小值
     * @param max 字符串长度最大值
     * @return 生成的中文字符串
     */
    public static String generateChinese(String min, String max) {
        String re = CN_REGEX_TEMPLATE.replace("min", min).replace("max", max);
        return generate(re);
    }

    /**
     * 生成单个手机号
     *
     * @return 单个手机号
     */
    public static String genPhone() {
        return generate(PHONE_REGEX);
    }


    /**
     * 生成多个手机号
     *
     * @param number 手机号数目
     * @return 多个手机号
     */
    public static String[] genPhone(int number) {
        return generate(PHONE_REGEX, number);
    }


    /**
     * 通过型根据正则表达式生成字符串
     *
     * @param regex  正则表达式
     * @param number 字符串数目
     * @return 生成的字符串数组
     */
    public static String[] generate(String regex, int number) {
        RgxGen rgxGen = new RgxGen(regex);
        String[] result = new String[number];
        for (int i = 0; i < number; i++) {
            result[i] = rgxGen.generate();
        }
        return result;
    }

    /**
     * 通过型根据正则表达式生成单个字符串
     *
     * @param regex 正则表达式
     * @return 生成的字符串
     */
    public static String generate(String regex) {
        RgxGen rgxGen = new RgxGen(regex);
        return rgxGen.generate();
    }
}
