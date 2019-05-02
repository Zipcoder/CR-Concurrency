package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class SafeCopierTest {

    String testString;

    @Before
    public void setup(){
        testString = "It was the best of times,\n" +
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
                "evil, in the superlative degree of comparison only. ";

    }
    @Test
    public void run() {
        SafeCopier safeCopier = new SafeCopier(testString);

        Thread monkeySafe1= new Thread(safeCopier);
        Thread monkeySafe2= new Thread(safeCopier);
        Thread monkeySafe3= new Thread(safeCopier);
        Thread monkeySafe4= new Thread(safeCopier);
        Thread monkeySafe5= new Thread(safeCopier);

        monkeySafe1.start();
        monkeySafe2.start();
        monkeySafe3.start();
        monkeySafe4.start();
        monkeySafe5.start();
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }


        String expected = testString;
        String actual = safeCopier.copied;

        Assert.assertEquals(expected,actual);

    }
}
