package com.github.evacode.common.generator.impl.random;

import com.github.evacode.common.util.JsonUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

/**
 * RandomStrGenerator Tester.
 */
public class RandomStrGeneratorTest {

    private int min;

    private int max;


    private int num;

    private int length;

    @Before
    public void before() {
        length = 10;
        num = 10000;
        min = 1;
        max = 10;
    }

    @Test
    public void testApacheRandomStringUtil() {
        StopWatch sw = new StopWatch();
        sw.start();
        Logger.getGlobal().info(JsonUtil.toJsonString(RandomStringUtils.randomAlphabetic(length)));
        sw.stop();
        Logger.getGlobal().info("耗时:" + sw.getNanoTime());
    }

    /**
     * Method: generate(int num)
     */
    @Test
    public void testGenerate() {
        RandomStrGenerator randomStrGenerator = new RandomStrGenerator();
        StopWatch sw = new StopWatch();
        sw.start();
        String[] result = randomStrGenerator.generate(num);
        sw.stop();
        Logger.getGlobal().info("耗时:" + sw.getNanoTime());
        Logger.getGlobal().info("数据:" + JsonUtil.toJsonString(result));
    }

    @Test
    public void testGenerateChinese() {
        char uMin = 0x4E00;
        char uMax = 0x9FA5;
        RandomStrGenerator randomStrGenerator = new RandomStrGenerator(min, max, uMin, uMax);
        StopWatch sw = new StopWatch();
        sw.start();
        String[] result = randomStrGenerator.generate(num);
        sw.stop();
        Logger.getGlobal().info("耗时:" + sw.getNanoTime());
        Logger.getGlobal().info("数据:" + JsonUtil.toJsonString(result));
    }

    @Test
    public void testGenerateEnglish() {
        char uMin = 0x0021;
        char uMax = 0x007E;
        RandomStrGenerator randomStrGenerator = new RandomStrGenerator(min, max, uMin, uMax);
        StopWatch sw = new StopWatch();
        sw.start();
        String[] result = randomStrGenerator.generate(num);
        sw.stop();
        Logger.getGlobal().info("耗时:" + sw.getNanoTime());
        Logger.getGlobal().info("数据:" + JsonUtil.toJsonString(result));
    }
}
