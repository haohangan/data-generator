package com.github.evacode.common;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * RegexGenUtil Tester.
 */
public class RegexGenUtilTest {

    String min;
    String max;

    int number;

    String regex_pattern;


    @Before
    public void before() {
        min = "2";
        max = "10";
        number = 100;
        regex_pattern = "aabb+cccc";
    }

    /**
     * Method: generateChinese(String min, String max, int number)
     */
    @Test
    public void testGenerateChineseForMinMaxNumber() {
        String[] result = RegexGenUtil.generateChinese(min, max, number);
        Assert.assertEquals(result.length, number);
    }


    /**
     * Method: generateChinese(String min, String max)
     */
    @Test
    public void testGenerateChineseForMinMax() {
        String result = RegexGenUtil.generateChinese(min, max);
        Assert.assertTrue(StringUtils.isNotBlank(result));
    }

    /**
     * Method: genPhone()
     */
    @Test
    public void testGenPhone() {
        String result = RegexGenUtil.genPhone();
        Assert.assertTrue(StringUtils.isNotBlank(result));
    }

    /**
     * Method: genPhone(int number)
     */
    @Test
    public void testGenPhoneNumber() {
        String[] result = RegexGenUtil.genPhone(number);
        Assert.assertEquals(result.length, number);
    }

    /**
     * Method: generate(String regex, int number)
     */
    @Test
    public void testGenerateForRegexNumber() {
        String[] result = RegexGenUtil.generate(regex_pattern, number);
        Assert.assertEquals(result.length, number);
    }

    /**
     * Method: generate(String regex)
     */
    @Test
    public void testGenerateRegex() {
        String result = RegexGenUtil.generate(regex_pattern);
        Assert.assertTrue(StringUtils.isNotBlank(result));
    }


} 
