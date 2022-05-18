package com.github.evacode.common.generator.impl.random;

import com.github.evacode.common.util.JsonUtil;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

public class ThreadLocalRandomTest {
    private int min;

    private int max;


    private int num;

    @Before
    public void before() {
        num = 100;
        min = 1;
        max = 10;
    }

    @Test
    public void simpleTest() {
        StopWatch sw = new StopWatch();
        sw.start();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            result.add(ThreadLocalRandom.current().nextInt(this.min, this.max + 1));
        }
        sw.stop();
        Logger.getGlobal().info("耗时:" + sw.getNanoTime());
        Logger.getGlobal().info("数据:" + JsonUtil.toJsonString(result));
        Assert.assertEquals(num, result.size());
    }
}
