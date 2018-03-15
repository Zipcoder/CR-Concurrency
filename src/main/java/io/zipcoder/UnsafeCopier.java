package io.zipcoder;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {

    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        while ( stringIterator.hasNext()) {         // stringIterator comes from Copier
            copied += stringIterator.next() + " ";
        }
    }
}


/*
Part 1

Made for you is an abstract base class of Copier which has a constructor that takes a String and turns that into an iterator.
This will allow us to traverse the text to be copied and pass it along to each monkey (thread).

Extend Copier in UnsafeCopier.
Then, write a run method that will have the monkey grab the next word and append it to the copy.

Modify MonkeyTypewriter to create 5 monkeys (threads) using the UnsafeCopier and start them.

After the sleep, print out the results of the unsafely copied passage.

Part 2

Finish the SafeCopier and then call that from the main method, in addition to the unsafe version.
 */
