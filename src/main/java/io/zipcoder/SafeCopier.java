package io.zipcoder;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {

    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    private Lock lock = new ReentrantLock();

    public void run() {
        while (stringIterator.hasNext()) {
            lock.lock();
            if (stringIterator.hasNext()) {
                String word = stringIterator.next();
                copied += word + " ";
            }
            lock.unlock();
        }
    }
}
