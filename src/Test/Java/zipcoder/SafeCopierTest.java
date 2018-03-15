package zipcoder;

import io.zipcoder.SafeCopier;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SafeCopierTest {
    String intro;
        @Before
        public void setUp() {
            intro = "It was the best of times,\n" +
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
    public void safeTest() {
        SafeCopier safeCopierTest = new SafeCopier(intro);

        Thread monkey = new Thread(safeCopierTest);
        Thread monkey1 = new Thread(safeCopierTest);
        Thread monkey2 = new Thread(safeCopierTest);
        Thread monkey3 = new Thread(safeCopierTest);
        Thread monkey4 = new Thread(safeCopierTest);

        monkey.start();
        monkey1.start();
        monkey2.start();
        monkey3.start();
        monkey4.start();

        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        String testString = safeCopierTest.copied;

        Assert.assertEquals(intro, testString);
    }
}
