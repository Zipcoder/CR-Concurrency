package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SafeCopierTest {

    String introduction = "It was the best of times,\n" +
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


    SafeCopier sc = new SafeCopier(introduction);

    Thread monkey1;
    Thread monkey2;
    Thread monkey3;
    Thread monkey4;
    Thread monkey5;



    @Before
    public void setup() {

        monkey1 = new Thread(sc);
        monkey2 = new Thread(sc);
        monkey3 = new Thread(sc);
        monkey4 = new Thread(sc);
        monkey5 = new Thread(sc);


    }

    @Test
        public void safeCopyTest1() {
        //Given BEFORE

        //When
        monkey1.start();
        monkey2.start();
        monkey3.start();
        monkey4.start();
        monkey5.start();

        String expected = introduction;
        String actual = sc.copied;
        //Then
        Assert.assertEquals(expected, actual);
    }

}