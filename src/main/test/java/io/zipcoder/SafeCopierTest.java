package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class SafeCopierTest {
    private String introduction = "It was the best of times,\n" +
            "it was the blurst of times,\n" +
            "it was the age of wisdom,\n" +
            "it was the age of foolishness,\n" +
            "it was the epoch of belief,\n" +
            "it was the epoch of incredulity,\n" +
            "it was the season of Light,\n" +
            "it was the season of Darkness,\n" +
            "it was the spring of hope,\n" +
            "it was the winter of despair,\n" +
            "we had everything before us,\n" +
            "we had nothing before us,\n" +
            "we were all going direct to Heaven,\n" +
            "we were all going direct the other way--\n" +
            "in short, the period was so far like the present period, that some of\n" +
            "its noisiest authorities insisted on its being received, for good or for\n" +
            "evil, in the superlative degree of comparison only.";
    private Copier s = new SafeCopier(introduction);
    private Thread[] safeThreads = new Thread[5];

    @Test
    public void operationTest1(){
        while (s.stringIterator.hasNext()) {
            for (int i = 0; i < safeThreads.length; i++) {
                safeThreads[i] = new Thread(s);
            }
            for (Thread thread : safeThreads) {
                thread.start();
            }
        }

        Assert.assertEquals(introduction + " ", s.copied);
    }
}
