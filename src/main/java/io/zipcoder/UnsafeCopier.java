package io.zipcoder;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {

    public UnsafeCopier(String toCopy) {

        super(toCopy);
    }

    public String getString() {
        return this.copied;
    }

    public void run() {
        //monkey grab the next word and append it to the copy.
        if (stringIterator.hasNext()) {
            this.copied += stringIterator.next() + " ";
        }
    }
}
