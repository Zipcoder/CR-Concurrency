package io.zipcoder;

import java.util.NoSuchElementException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {

    private Lock lock;

    public SafeCopier(String theString) {
        super(theString);
        lock = new ReentrantLock();

    }

    public void run() {
        try {
            Thread.sleep(25);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (stringIterator.hasNext()) {
            try {
                lock.lock();
                copied += stringIterator.next() + " " + Thread.currentThread().getName() + " ";

            } catch (NoSuchElementException e) {

            } finally {
                lock.unlock();
            }
        }


    }
}
