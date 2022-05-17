package com.github.evacode.common.generator;

import com.github.evacode.common.generator.impl.RandomIntGenerator;
import com.github.evacode.common.util.JsonUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

public class RandomIntGeneratorTest {

    private int min;

    private int max;


    private int num;

    @Before
    public void before() {
        num = 10;
        min = 1;
        max = 100;
    }


    @Test
    public void testGenerateChineseForMinMaxNumber() {
        StopWatch sw = new StopWatch();
        sw.start();
        IntGenerator ig = new RandomIntGenerator(min, max);
        int[] result = ig.generate(num);
        sw.stop();
        Logger.getGlobal().info("耗时:" + sw.getNanoTime());
        Logger.getGlobal().info("耗时:" + JsonUtil.toJsonString(result));
        Assert.assertEquals(num, ArrayUtils.getLength(result));
    }

}
