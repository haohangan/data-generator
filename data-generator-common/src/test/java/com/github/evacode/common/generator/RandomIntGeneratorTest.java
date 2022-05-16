package com.github.evacode.common.generator;

import com.github.evacode.common.generator.impl.RandomIntGenerator;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

public class RandomIntGeneratorTest {


    @Test
    public void testGenerateChineseForMinMaxNumber() {
        StopWatch sw = new StopWatch();
        sw.start();
        IntGenerator ig = new RandomIntGenerator(10);
        int[] result = ig.generate(10);
        sw.stop();
        System.out.println("耗时:" + sw.getNanoTime());
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
