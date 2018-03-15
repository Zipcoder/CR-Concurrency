package io.zipcoder;

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

        UnsafeCopier unsafeCopier = new UnsafeCopier(introduction);

        Thread monkeyUnsafe1 = new Thread(unsafeCopier);
        Thread monkeyUnsafe2 = new Thread(unsafeCopier);
        Thread monkeyUnsafe3 = new Thread(unsafeCopier);
        Thread monkeyUnsafe4 = new Thread(unsafeCopier);
        Thread monkeyUnsafe5 = new Thread(unsafeCopier);

        monkeyUnsafe1.start();
        monkeyUnsafe2.start();
        monkeyUnsafe3.start();
        monkeyUnsafe4.start();
        monkeyUnsafe5.start();

        // creating new safeCopier object & passing string introduction as a parameter

        SafeCopier safeCopier = new SafeCopier(introduction);

        // creating 5 safe threads and passing the safe copier obj into their constructors
        Thread monkeySafe1 = new Thread(safeCopier);
        Thread monkeySafe2 = new Thread(safeCopier);
        Thread monkeySafe3 = new Thread(safeCopier);
        Thread monkeySafe4 = new Thread(safeCopier);
        Thread monkeySafe5 = new Thread(safeCopier);

        // we are starting the threads
        monkeySafe1.start();
        monkeySafe2.start();
        monkeySafe3.start();
        monkeySafe4.start();
        monkeySafe5.start();

        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.
        System.out.println("Unsafe: \n");
        System.out.println(unsafeCopier.copied);
        System.out.println("\nSafe: \n");

        System.out.println(safeCopier.copied);
    }
}