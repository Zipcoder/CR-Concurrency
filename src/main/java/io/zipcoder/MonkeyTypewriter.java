package io.zipcoder;

/**
 * @TODO
 * @Part1 - Extend copier in the unsafeCopier class
 *        - After that create a run method that will
 *          grab the next word and add it to the copy
 *        - Modify this class to create 5 threads using
 *          the unsafierCopier and start them
 * @Part2 - Finish the safecopier class and call it from
 *          the main method along with the unsafecopier
 */

public class MonkeyTypewriter {
    public static void main(String[] args) {
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
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.
        //Safe threads
        SafeCopier sc = new SafeCopier(introduction); //contstructing safe/unsafe copies of the introduction
        UnsafeCopier usc = new UnsafeCopier(introduction);

        Thread monkeySafe1 = new Thread(sc);
        Thread monkeySafe2 = new Thread(sc);
        Thread monkeySafe3 = new Thread(sc);
        Thread monkeySafe4 = new Thread(sc);
        Thread monkeySafe5 = new Thread(sc);
        //Unsafe threads
        Thread monkeyUnsafe1 = new Thread(usc);
        Thread monkeyUnsafe2 = new Thread(usc);
        Thread monkeyUnsafe3 = new Thread(usc);
        Thread monkeyUnsafe4 = new Thread(usc);
        Thread monkeyUnsafe5 = new Thread(usc);
        //For each one of these copiers, make 5 monkeys start copying the intro
        monkeySafe1.start();
        monkeySafe2.start();
        monkeySafe3.start();
        monkeySafe4.start();
        monkeySafe5.start();
        //start unsafe copies
        monkeyUnsafe1.start();
        monkeyUnsafe2.start();
        monkeyUnsafe3.start();
        monkeyUnsafe4.start();
        monkeyUnsafe5.start();
        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000); //wait time between each thread request
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }
        // Print out the copied versions here.
        System.out.println(sc.copied + "\n"); //printing will be exactly as expected since it is locked
        System.out.println(usc.copied); //printing of this will have unpredictable behavior and results are not safe due to lack of lock
    }
}